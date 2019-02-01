package com.nvoulgaris.cosmoseye.features.apod.presentation

data class Apod(
    private val copyright: String,
    private val date: String,
    private val explanation: String,
    private val hdUrl: String,
    private val mediaType: String,
    private val serviceVersion: String,
    private val title: String,
    private val url: String
)
