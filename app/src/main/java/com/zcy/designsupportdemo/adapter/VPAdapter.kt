package com.zcy.designsupportdemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by zcy on 2017/9/21.
 */
//在主构造函数里，可以将参数声明成类的属性。
//也可以用这些参数变量赋值给类的属性。
class VPAdapter(fm: FragmentManager, private val mFragments: List<Fragment>, private val mTitles: Array<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }


}
