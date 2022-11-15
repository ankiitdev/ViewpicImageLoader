package ankiitdev.viewpic.cache

import android.graphics.Bitmap

interface ImageCache {

    fun addImage(url: String, bitmap: Bitmap)
    fun getImage(url: String): Bitmap?
    fun clearImages()

}