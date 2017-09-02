package it.polimi.bookshelf.data;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import it.polimi.bookshelf.objects.User;

/* this class contains generic functions in order to interface with Firebase realtime database
* for configuring and managing your cloud database visit: https://console.firebase.google.com/
* for more complete examples visit: https://firebase.google.com/docs/database
*/

public class CloudHandler {

	private FirebaseDatabase fDB;

	public CloudHandler() {
		fDB = FirebaseDatabase.getInstance();
	}

	/*
	* returns the reference to the database at the specified location
	* @param reference the string of the location (example reference = "users")
	*/
	public DatabaseReference getReference(String reference) {

		return this.fDB.getReference(reference);
	}

	/*
	* allows to manipulate data in realtime
	* @param reference the DatabaseReference
	*/
	public void addListener(DatabaseReference reference) {

		reference.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				// This method is called once with the initial value and again
				// whenever data at this location is updated.
				// for a callback called just once -> addListenerForSingleValueEvent()
				String value = dataSnapshot.getValue(String.class);
				Log.d("FIREBASE", "Value is: " + value);
			}

			@Override
			public void onCancelled(DatabaseError error) {
				// Failed to read value
				Log.w("FIREBASE", "Failed to read value.", error.toException());
			}
		});
	}

	/*
	* allows to add a new object to the database
	* @param object
	*/
	public void addUser(User user) {

		// modify the reference and the ID with the values in your Firebase console
		/*try{
			
			//checks if user already exists
			DatabaseReference ref = getReference("users").child("user.getuser_ID");
		    ref.addListenerForSingleValueEvent(new ValueEventListener() {
		    	@Override
		        public void onDataChange(DataSnapshot snapshot) {
		            if (snapshot.exists()) {
		                // handle the case that object already exists
		            }
		            else {
		                ref.setValue(user);
		            }
		            progressDialog.dismiss();
		        }
		
		        @Override
		        public void onCancelled(DatabaseError databaseError) {}
		    });
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		*/
	}

	/*
	* allows to update an object in the database
	* @param object
	*/
	public void updateUser(String access_email, String password, String user_name, String user_surname) {

		User user = new User(access_email, password, user_name, user_surname);
		// modify the reference and the ID with the values in your Firebase console
		/*try{
			getReference("users").child("user_ID").setValue(user);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		*/
	}

	/*
	* allows to delete an object from the database
	* @param objectId
	*/
	public void deleteUser(String objectId) {

		// modify the reference and the ID with the values in your Firebase console
		//getReference("users").child(objectId).removeValue();
	}

}
