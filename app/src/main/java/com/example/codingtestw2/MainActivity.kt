package com.example.codingtestw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Problem 1:  Sort the array with multiple same values
    val intArray = intArrayOf(2,8,9,3,4,3,2,6,6,2,4,9,8)

    intArray.sort()

        Log.d("SORT", "Output: ${intArray.joinToString()}")



        //Problem 2:   algorithm to collect and return a list of all substrings such that order is maintained but characters may be skipped


        val arg = "frog"


        fun subStrRecursive(str: String): List<String> {
            if (str.length == 1) return listOf(str, "")

            val firstChar = str.first().toString()
            val lastN = str.drop(1)
            val subs: List<String> = subStrRecursive(lastN)
            return subs.map{ it -> firstChar + it} + subs
        }

        Log.d("SUBSTRING", "Output: ${subStrRecursive(arg).sorted()}")


        //Problem 3:

        data class Position(val row: Int, val col: Int) {}
        data class StringEntry(val pos: Position, val str: String) {}


        val list: Array<Array<String>> = arrayOf(
            arrayOf("a", "b", "c"),
            arrayOf("d", "e", "f"),
            arrayOf("g", "a", "b")
        )

        fun duplicates(arr: Array<Array<String>>): MutableList<Position> {
            val entries: MutableList<StringEntry> = mutableListOf()

            for(i in arr.indices) {
                for(j in arr[i].indices) {
                    entries.add(StringEntry(Position(i,j), arr[i][j]))
                }
            }

            entries.sortWith ( object: Comparator<StringEntry> {
                override fun compare(a: StringEntry, b: StringEntry) = a.str.compareTo(b.str)
            })

            val duplicatePositions: MutableList<Position> = mutableListOf()
            var lastEntry = StringEntry(Position(0,0), "")
            for (i in entries.indices) {
                if (lastEntry.str == entries[i].str) {
                    duplicatePositions.add(entries[i].pos.copy())
                    duplicatePositions.add(lastEntry.pos.copy())
                }
                    lastEntry = entries[i]
                }

                return duplicatePositions
            }

        Log.d("DUPLICATES", "Output: ${duplicates(list)}")



        //Problem 4:



    }

}
