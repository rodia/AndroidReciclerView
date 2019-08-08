package com.example.reciclerviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private val LOG_TAG: String? = "Theme"
    private var mySwipeRefreshLayout: SwipeRefreshLayout? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val musics: ArrayList<Music> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addMusics()
        viewManager = LinearLayoutManager(this)
        viewAdapter = MusicAdapter(musics, this)

        recyclerView = findViewById<RecyclerView>(R.id.rv_music_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        mySwipeRefreshLayout = findViewById(R.id.swiperefresh)
        /*
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * performs a swipe-to-refresh gesture.
         */
        mySwipeRefreshLayout!!.setOnRefreshListener {
            Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout")

            // This method performs the actual data-refresh operation.
            // The method calls setRefreshing(false) when it's finished.
            //myUpdateOperation()
            Thread.sleep(1_000)

            mySwipeRefreshLayout!!.isRefreshing = false
        }
    }

    /*
     * Listen for option item selections so that we receive a notification
     * when the user requests a refresh by selecting the refresh action bar item.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            // Check if user triggered a refresh:
            R.id.menu_refresh -> {
                Log.i(LOG_TAG, "Refresh menu item selected")

                // Signal SwipeRefreshLayout to start the progress indicator
                mySwipeRefreshLayout!!.isRefreshing = true

                // Start the refresh background task.
                // This method calls setRefreshing(false) when it's finished.
                //myUpdateOperation()

                return true
            }
        }

        // User didn't trigger a refresh, let the superclass handle this action
        return super.onOptionsItemSelected(item)
    }

    private fun addMusics() {
        musics.add(Music("Imagine", "John Lennon", "1971"))
        musics.add(Music("Stairway To Heaven", "Led Zeppelin", "1971"))
        musics.add(Music("Let It Be (cancion)", "The Beatles", "1970"))
        musics.add(Music("I Can't Get No Satisfaction", "The Rolling Stones", "1965"))
        musics.add(Music("Hey Jude", "The Beatles", "1968"))
        musics.add(Music("Comfortably Numb", "Pink Floyd", "1979"))
        musics.add(Music("Light My Fire", "The Doors", "1967"))
        musics.add(Music("Good Vibrations", "The Beach Boys", "1966"))
        musics.add(Music("Like A Rolling Stone", "Bob Dylan", "1965"))
        musics.add(Music("Bohemian Rhapsody", "Queen", "1975"))
        musics.add(Music("Wish You Were Here", "Pink Floyd", "1975"))
        musics.add(Music("Yesterday", "The Beatles", "1965"))
        musics.add(Music("My Generation", "The Who", "1965"))
        musics.add(Music("What's Going On", "Marvin Gaye", "1971"))
        musics.add(Music("Johnny B. Goode", "Chuck Berry", "1958"))
        musics.add(Music("Layla", "Derek and the Dominos", "1970"))
        musics.add(Music("Won't Get Fooled Again", "The Who", "1971"))
        musics.add(Music("While My Guitar Gently Weeps", "The Beatles", "1968"))
        musics.add(Music("Paint It, Black", "The Rolling Stones", "1966"))
        musics.add(Music("A Day in the Life", "The Beatles", "1967"))
        musics.add(Music("I Got You (I Feel Good)", "James Brown", "1965"))
        musics.add(Music("I Want To Hold Your Hand", "The Beatles", "1964"))
        musics.add(Music("Superstition", "Stevie Wonder", "1972"))
        musics.add(Music("Brown Sugar", "The Rolling Stones", "1971"))
        musics.add(Music("Purple Haze", "The Jimi Hendrix Experience", "1967"))
        musics.add(Music("Sympathy for the Devil", "The Rolling Stones", "1968"))
        musics.add(Music("It's My Life", "Bon Jovi", "2000"))
        musics.add(Music("You Really Got Me", "The Kinks", "1964"))
        musics.add(Music("Oh, Pretty Woman", "Roy Orbison", "1964"))
        musics.add(Music("Bridge over Troubled Water", "Simon and Garfunkel", "1970"))
        musics.add(Music("Hound Dog", "Elvis Presley", "1956"))
        musics.add(Music("Come Together", "The Beatles", "1969"))
        musics.add(Music("(Sittin' On) The Dock of the Bay", "Otis Redding", "1968"))
        musics.add(Music("All Along the Watchtower", "Jimi Hendrix Experience", "1968"))
        musics.add(Music("Walk This Way", "Aerosmith", "1976"))
        musics.add(Music("My Girl", "The Temptations", "1965"))
        musics.add(Music("Rock Around the Clock", "Bill Haley and His Comets", "1954"))
        musics.add(Music("I Heard I Through The Grapevine", "Marvin Gaye", "1968"))
        musics.add(Music("Proud Mary", "Creedence Clearwater Revival", "1969"))
        musics.add(Music("Born to Be Wild", "Steppenwolf", "1968"))
        musics.add(Music("Smells Like Teen Spirit", "Nirvana", "1991"))
        musics.add(Music("Every breath you take", "The Police", "1983"))
        musics.add(Music("What'd I say", "Ray Charles", "1959"))
        musics.add(Music("Free Bird", "Lynyrd Skynyrd", "1974"))
        musics.add(Music("That'll Be the Day", "Buddy Holly", "1957"))
        musics.add(Music("Whole Lotta Love", "Led Zeppelin", "1969"))
        musics.add(Music("Dream On", "Aerosmith", "1973"))
        musics.add(Music("California Dreamin'", "The Mamas & the Papas", "1966"))
        musics.add(Music("The Show Must Go On", "Queen", "1991"))
        musics.add(Music("Wild Things", "The Troggs", "1966"))
        musics.add(Music("Suite: Judy Blue Eyes", "Crosby, Stills, Nash & Young", "1969"))
        musics.add(Music("Beat It", "Michael Jackson", "1982"))
        musics.add(Music("Another Brick In The Wall", "Pink Floyd", "1979"))
        musics.add(Music("Stayin' Alive", "The Bee Gees", "1977"))
        musics.add(Music("For What It's Worth", "Buffalo Springfield", "1967"))
        musics.add(Music("Blowin' in the Wind", "Bob Dylan", "1963"))
        musics.add(Music("Twist and Shout", "The Beatles", "1963"))
        musics.add(Music("Piano Man", "Billy Joel", "1973"))
        musics.add(Music("She Loves You", "The Beatles", "1963"))
        musics.add(Music("Space Oddity", "David Bowie", "1969"))
        musics.add(Music("Strawberry Fields Forever", "The Beatles", "1967"))
        musics.add(Music("Kashmir", "Led Zeppelin", "1975"))
        musics.add(Music("Crazy", "Patsy Cline", "1961"))
        musics.add(Music("London Calling", "The Clash", "1979"))
        musics.add(Music("Jumpin' Jack Flash", "The Rolling Stones", "1968"))
        musics.add(Music("Rock and Roll", "Led Zeppelin", "1971"))
        musics.add(Music("Sweet Child O' Mine", "Guns N' Roses", "1987"))
        musics.add(Music("All Shook Up", "Elvis Presley", "1957"))
        musics.add(Music("Maggie May", "Rod Stewart", "1971"))
        musics.add(Music("Your Song", "Elton John", "1970"))
        musics.add(Music("Heartbreak Hotel", "Elvis Presley", "1956"))
        musics.add(Music("God Only Knows", "The Beach Boys", "1966"))
        musics.add(Music("The Twist", "Chubby Checker", "1960"))
        musics.add(Music("Good Golly, Miss Molly", "Little Richard", "1957"))
        musics.add(Music("Sunshine of Your Love", "Cream", "1967"))
        musics.add(Music("California Girls", "The Beach Boys", "1965"))
        musics.add(Music("Summertime Blues", "Eddie Cochran", "1958"))
        musics.add(Music("Blue Suede Shoes", "Carl Perkins", "1956"))
        musics.add(Music("A Hard Day's Night", "The Beatles", "1967"))
        musics.add(Music("Fire and Rain", "James Taylor", "1970"))
        musics.add(Music("Gloria", "Them", "1964"))
        musics.add(Music("Sexual Healing", "Marvin Gaye", "1982"))
        musics.add(Music("Start Me Up", "The Rolling Stones", "1981"))
        musics.add(Music("More Than a Feeling", "Boston", "1976"))
        musics.add(Music("Roxanne", "The Police", "1978"))
        musics.add(Music("We Are the Champions", "Queen", "1977"))
        musics.add(Music("Tangled Up in Blue", "Bob Dylan", "1975"))
        musics.add(Music("Somebody to Love", "Jefferson Airplane", "1967"))
        musics.add(Music("Stand by Me", "Ben E. King", "1961"))
        musics.add(Music("Whole Lotta Shakin' Going On", "Jerry Lee Lewis", "1957"))
        musics.add(Music("November rain", "Guns N' Roses", "1991"))
        musics.add(Music("When Doves Cry", "Prince", "1984"))
        musics.add(Music("In The Midnight Hour", "Wilson Pickett", "1966"))
        musics.add(Music("Gimme Some Lovin'", "Spencer Davis Group", "1999"))
        musics.add(Music("Jump", "Van Halen", "1984"))
        musics.add(Music("Thunder Road", "Bruce Springsteen", "1975"))
        musics.add(Music("No Woman, No Cry", "Bob Marley & The Wailers", "1974"))
        musics.add(Music("La bamba", "Ritchie Valens", "1958"))
        musics.add(Music("We've Only Just Begun", "The Carpenters", "1970"))
        musics.add(Music("Papa Was a Rollin' Stone", "The Temptations", "1972"))
    }
}
