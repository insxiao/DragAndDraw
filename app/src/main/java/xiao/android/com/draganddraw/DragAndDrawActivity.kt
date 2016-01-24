package xiao.android.com.draganddraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle
import android.support.v4.app.Fragment

class DragAndDrawActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment {
        return DragAndDrawFragment()
    }
}

