package xiao.android.com.draganddraw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity() {
    abstract fun createFragment(): Fragment;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.fragment_container)
        val fragment = createFragment()
        if (fragmentContainer != null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
        } else {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
