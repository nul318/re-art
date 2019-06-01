package com.musica.android.reart.adapater

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.musica.android.reart.Fragment.FlagFragment
import com.musica.android.reart.Fragment.heartFragment


class MyFragmentStatePagerAdapter(fm: FragmentManager, val fragmentCount: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return heartFragment()
            1 -> {
                val FlagFragment: Fragment = FlagFragment()
                return FlagFragment
            }
            else -> return null
        }
    }

    override fun getCount(): Int = fragmentCount
}