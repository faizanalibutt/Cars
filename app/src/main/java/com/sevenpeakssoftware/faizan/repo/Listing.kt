package com.sevenpeakssoftware.faizan.repo

import androidx.lifecycle.LiveData
import com.sevenpeakssoftware.faizan.utils.NetworkState

/**
 * Data class that is necessary for a UI to show a listing and interact w/ the rest of the system
 */
data class Listing<CarArticlesModel>(
        // the LiveData of paged lists for the UI to observe
    val pagedList: LiveData<List<CarArticlesModel>>,
        // represents the network request status to show to the user
    val networkState: LiveData<NetworkState>,
        // retries any failed requests.
    val retry: () -> Unit)