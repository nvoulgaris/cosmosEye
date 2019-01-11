package com.nvoulgaris.cosmoseye.application

import com.nvoulgaris.cosmoseye.apod.data.ApodDataModule
import dagger.Module

@Module(includes = [RoomModule::class, ApodDataModule::class])
class DataModule
