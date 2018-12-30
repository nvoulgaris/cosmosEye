package com.nvoulgaris.cosmoseye.apod.mocks

import com.nvoulgaris.cosmoseye.apod.data.ApodRaw
import com.nvoulgaris.cosmoseye.apod.domain.ApodDb
import com.nvoulgaris.cosmoseye.apod.presentation.Apod

class MockedApods {

    companion object {

        val apodRaw1 = ApodRaw(
            "Magnus Edback",
            "2018-12-21",
            "Welcome to the December Solstice, the first day of winter in planet",
            "https://apod.nasa.gov/apod/image/1812/IMG_8741_cSunHaloEdback2048.jpg",
            "image",
            "v1",
            "Extraordinary Solar Halos",
            "https://apod.nasa.gov/apod/image/1812/IMG_8741_cSunHaloEdback1024.jpg"
        )

        val apodRaw2 = ApodRaw(
            "Tom Masterson",
            "2018-12-20",
            "This festively colored skyscape was captured in the early morning",
            "https://apod.nasa.gov/apod/image/1812/M45-CaliNeb-46P-TomMasterson-GrandMesaObservatory.jpg",
            "image",
            "v1",
            "Red Nebula, Green Comet, Blue Stars",
            "https://apod.nasa.gov/apod/image/1812/M45-CaliNeb-46P-TomMasterson-GrandMesaObservatory1024.jpg"
        )

        val apodDb1 = ApodDb(
            "Magnus Edback",
            "2018-12-21",
            "Welcome to the December Solstice, the first day of winter in planet",
            "https://apod.nasa.gov/apod/image/1812/IMG_8741_cSunHaloEdback2048.jpg",
            "image",
            "v1",
            "Extraordinary Solar Halos",
            "https://apod.nasa.gov/apod/image/1812/IMG_8741_cSunHaloEdback1024.jpg"
        )

        val apodDb2 = ApodDb(
            "Tom Masterson",
            "2018-12-20",
            "This festively colored skyscape was captured in the early morning",
            "https://apod.nasa.gov/apod/image/1812/M45-CaliNeb-46P-TomMasterson-GrandMesaObservatory.jpg",
            "image",
            "v1",
            "Red Nebula, Green Comet, Blue Stars",
            "https://apod.nasa.gov/apod/image/1812/M45-CaliNeb-46P-TomMasterson-GrandMesaObservatory1024.jpg"
        )

        val apod1 = Apod(
            "Magnus Edback",
            "2018-12-21",
            "Welcome to the December Solstice, the first day of winter in planet",
            "https://apod.nasa.gov/apod/image/1812/IMG_8741_cSunHaloEdback2048.jpg",
            "image",
            "v1",
            "Extraordinary Solar Halos",
            "https://apod.nasa.gov/apod/image/1812/IMG_8741_cSunHaloEdback1024.jpg"
        )

        val apod2 = Apod(
            "Tom Masterson",
            "2018-12-20",
            "This festively colored skyscape was captured in the early morning",
            "https://apod.nasa.gov/apod/image/1812/M45-CaliNeb-46P-TomMasterson-GrandMesaObservatory.jpg",
            "image",
            "v1",
            "Red Nebula, Green Comet, Blue Stars",
            "https://apod.nasa.gov/apod/image/1812/M45-CaliNeb-46P-TomMasterson-GrandMesaObservatory1024.jpg"
        )
    }
}
