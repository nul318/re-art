package com.musica.android.reart.activities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.musica.android.reart.R
import com.musica.android.reart.adapater.MyFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_mypage.*

class MypageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)
        configureBottomNavigation()
    }
    private fun configureBottomNavigation(){
        vp_bottom_navi_act_frag_pager.adapter = MyFragmentStatePagerAdapter(supportFragmentManager, 2)
//vp_bottom_navi_act_frag_pager.offscreenPageLimit = 3
// ViewPager와 Tablayout을 엮어줍니다!
        tl_bottom_navi_act_bottom_menu.setupWithViewPager(vp_bottom_navi_act_frag_pager)
//TabLayout에 붙일 layout을 찾아준 다음
        var bottomNaviLayout : View = this.layoutInflater.inflate(R.layout.tabbar, null, false)
//탭 하나하나 TabLayout에 연결시켜줍니다.
        tl_bottom_navi_act_bottom_menu.getTabAt(0)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_main_tab) as RelativeLayout
        tl_bottom_navi_act_bottom_menu.getTabAt(1)!!.customView = bottomNaviLayout.findViewById(R.id.btn_bottom_navi_map_tab) as RelativeLayout
    }
}
