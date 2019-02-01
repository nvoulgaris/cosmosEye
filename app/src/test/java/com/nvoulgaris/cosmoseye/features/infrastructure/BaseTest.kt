package com.nvoulgaris.cosmoseye.features.infrastructure

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule

open class BaseTest {

    @Rule
    @JvmField
    val immediateSchedulerRule = RxMockSchedulersRule()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()
}
