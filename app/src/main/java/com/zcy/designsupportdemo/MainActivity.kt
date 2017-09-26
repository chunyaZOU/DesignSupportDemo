package com.zcy.designsupportdemo

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.zcy.designsupportdemo.adapter.VPAdapter
import com.zcy.designsupportdemo.fragment.ItemFragment
import com.zcy.designsupportdemo.fragment.OtherFragment
import com.zcy.designsupportdemo.fragment.dummy.DummyContent

import java.util.ArrayList

//导入指定布局文件中所有控件属性，导入完成后即可调用在xml中以视图控件命名属性的对应扩展。
import kotlinx.android.synthetic.main.tab_bar_main.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ItemFragment.OnListFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //已导入布局文件所有控件属性，可以直接使用控件名称fab
        //fab!!，如果fab为null，抛出一个空指针异常
        //fab?,如果fab为null,返回null，不做处理
        fab!!.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action") { Toast.makeText(this@MainActivity, "This is Toast", Toast.LENGTH_SHORT).show() }.show()
        }
        //val:只读变量，线程安全，不用担心null问题
        //kotlin没有new关键字，直接使用构造函数创建实例
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout!!.setDrawerListener(toggle)
        toggle.syncState()

        nav_view!!.setNavigationItemSelectedListener(this)
        setupViewPager()
    }


    private fun setupViewPager() {
        val fragments = ArrayList<Fragment>()
        //..区间
        for (i in 0..3) {
            if (i == 3)
                fragments.add(OtherFragment.newInstance("", ""))
            else
                fragments.add(ItemFragment.newInstance(i + 1))
            tab_layout!!.addTab(tab_layout!!.newTab().setText(resources.getStringArray(R.array.tab_titles)[i]))
        }
        val adapter = VPAdapter(supportFragmentManager, fragments, resources.getStringArray(R.array.tab_titles))
        vp!!.adapter = adapter
        tab_layout!!.setupWithViewPager(vp)
    }

    override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            Snackbar.make(tab_layout,"settings",Snackbar.LENGTH_SHORT).show()
            return true
        }else if(id==R.id.action_search){
            Snackbar.make(tab_layout,"search",Snackbar.LENGTH_SHORT).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {

    }
}
