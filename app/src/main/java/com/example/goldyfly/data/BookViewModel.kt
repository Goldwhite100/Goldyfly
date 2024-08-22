package com.example.goldyfly.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.goldyfly.models.Book
import com.example.goldyfly.navigation.BOOKING_URL

import com.example.goldyfly.navigation.ROUT_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class BookViewModel(var navController: NavController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadBooking(name:String, currentlocation:String,destination:String, phone: String,filePath: Uri){
        val bookId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Books/$bookId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var product = Book(name,currentlocation,destination,phone,imageUrl,bookId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Books/$bookId")
                    databaseRef.setValue(product).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allBookings(
        book: MutableState<Book>,
        books: SnapshotStateList<Book>
    ):SnapshotStateList<Book>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Books")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                books.clear()
                for (snap in snapshot.children){
                    var retrievedBooking = snap.getValue(Book::class.java)
                    book.value = retrievedBooking!!
                    books.add(retrievedBooking)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return books
    }

    fun updateBooking(bookId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Books/$bookId")
        ref.removeValue()
        navController.navigate(BOOKING_URL)
    }


    fun deleteBooking(bookId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Books/$bookId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}