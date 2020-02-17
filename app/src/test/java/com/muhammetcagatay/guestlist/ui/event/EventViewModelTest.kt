package com.muhammetcagatay.guestlist.ui.event

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.cagataymuhammet.guestlist.ui.event.EventViewModel
import com.muhammetcagatay.guestlist.util.InstantExecutorExtension
import com.muhammetcagatay.guestlist.util.TestModelsGenerator
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class EventViewModelTest {

    // Subject under test
    private lateinit var eventViewModel: EventViewModel

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    private lateinit var eventName: String
    private val testModelsGenerator: TestModelsGenerator = TestModelsGenerator()

    @Before
    fun setUp() {
        // Create class under test
        // We initialise the repository with no tasks
        eventName = testModelsGenerator.generateEventResponse().results.get(0).name
        val newsModelSuccess =  eventViewModel.getLocaleEvents()
    }

    @Test
    fun handleEventList() {

        val isEmptyList =eventName.isNullOrEmpty()
        assert(!isEmptyList)
    }


}