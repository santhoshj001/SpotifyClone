package com.teamb.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.teamb.spotifyclone.common.Constants
import com.teamb.spotifyclone.data.entity.Song
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(Constants.SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch(e: Exception) {
            emptyList()
        }
    }
}