package com.nvoulgaris.cosmoseye.application

import com.nvoulgaris.cosmoseye.features.apod.data.ApodDataModule
import dagger.Module

@Module(includes = [RoomModule::class, ApodDataModule::class])
class DataModule
