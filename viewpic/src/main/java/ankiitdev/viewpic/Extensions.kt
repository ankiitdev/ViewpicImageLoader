package ankiitdev.viewpic

import android.widget.ImageView
import ankiitdev.viewpic.core.Viewpic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ImageView.loadImage(url: String, placeholder: Int?) {
    CoroutineScope(Dispatchers.Main).launch {
        Viewpic.getInstance(this@loadImage.context).displayImage(url, this@loadImage, placeholder)
    }
}
