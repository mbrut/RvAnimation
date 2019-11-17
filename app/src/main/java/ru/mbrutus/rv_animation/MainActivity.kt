package ru.mbrutus.rv_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mData: MutableList<NewsItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        gen_test_data()
        val newsAdapter = NewsAdapter(mData)
        news_rv.adapter = newsAdapter
        news_rv.layoutManager = LinearLayoutManager(this )

        fab_switcher.setOnClickListener {
            if (delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
            } else {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            }
            SharedPrefsRepository.saveThemeState(delegate.localNightMode)
        }
        search_et.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                newsAdapter.filter.filter(s)
            }
        })

    }

    fun gen_test_data() {
        mData.add(
            NewsItem(
                1,
                "OnePlus 6T Camera Review:",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "6 july 1994",
                R.drawable.user
            )
        )
        mData.add(
            NewsItem(
                2,
                "I love Programming And Design",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
                "6 july 1994",
                R.drawable.circul6
            )
        )
        mData.add(
            NewsItem(
                3,
                "My first trip to Thailand story ",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "6 july 1994",
                R.drawable.uservoyager
            )
        )
        mData.add(
            NewsItem(
                4,
                "After Facebook Messenger, Viber now gets...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
                "6 july 1994",
                R.drawable.useillust
            )
        )
        mData.add(
            NewsItem(
                5,
                "Isometric Design Grid Concept",
                "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit",
                "6 july 1994",
                R.drawable.circul6
            )
        )
        mData.add(
            NewsItem(
                6,
                "Android R Design Concept 4K",
                "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ",
                "6 july 1994",
                R.drawable.user
            )
        )
        mData.add(
            NewsItem(
                7,
                "OnePlus 6T Camera Review:",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "6 july 1994",
                R.drawable.user
            )
        )
        mData.add(
            NewsItem(
                8,
                "I love Programming And Design",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
                "6 july 1994",
                R.drawable.circul6
            )
        )
        mData.add(
            NewsItem(
                9,
                "My first trip to Thailand story ",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "6 july 1994",
                R.drawable.uservoyager
            )
        )
        mData.add(
            NewsItem(
                10,
                "After Facebook Messenger, Viber now gets...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
                "6 july 1994",
                R.drawable.useillust
            )
        )
        mData.add(
            NewsItem(
                11,
                "Isometric Design Grid Concept",
                "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit",
                "6 july 1994",
                R.drawable.circul6
            )
        )
        mData.add(
            NewsItem(
                12,
                "Android R Design Concept 4K",
                "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ",
                "6 july 1994",
                R.drawable.user
            )
        )
        mData.add(
            NewsItem(
                13,
                "OnePlus 6T Camera Review:",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "6 july 1994",
                R.drawable.user
            )
        )
        mData.add(
            NewsItem(
                14,
                "I love Programming And Design",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
                "6 july 1994",
                R.drawable.circul6
            )
        )
        mData.add(
            NewsItem(
                15,
                "My first trip to Thailand story ",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "6 july 1994",
                R.drawable.uservoyager
            )
        )
        mData.add(
            NewsItem(
                16,
                "After Facebook Messenger, Viber now gets...",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
                "6 july 1994",
                R.drawable.useillust
            )
        )
        mData.add(
            NewsItem(
                17,
                "Isometric Design Grid Concept",
                "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit",
                "6 july 1994",
                R.drawable.circul6
            )
        )
        mData.add(
            NewsItem(
                18,
                "Android R Design Concept 4K",
                "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ",
                "6 july 1994",
                R.drawable.user
            )
        )
    }

}
