package com.example.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.ui.theme.SuperHeroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroLists()
                }
            }
        }
    }
}

fun getData(): List<SuperHero> {
    return listOf(
        SuperHero(
            name = R.string.hero1,
            description = R.string.description1,
            image = R.drawable.android_superhero1
        ),
        SuperHero(
            name = R.string.hero2,
            description = R.string.description2,
            image = R.drawable.android_superhero2
        ),
        SuperHero(
            name = R.string.hero3,
            description = R.string.description3,
            image = R.drawable.android_superhero3
        ),
        SuperHero(
            name = R.string.hero4,
            description = R.string.description4,
            image = R.drawable.android_superhero4
        ),
        SuperHero(
            name = R.string.hero5,
            description = R.string.description5,
            image = R.drawable.android_superhero5
        ),
        SuperHero(
            name = R.string.hero1,
            description = R.string.description1,
            image = R.drawable.android_superhero1
        ),
        SuperHero(
            name = R.string.hero2,
            description = R.string.description2,
            image = R.drawable.android_superhero2
        ),
        SuperHero(
            name = R.string.hero3,
            description = R.string.description3,
            image = R.drawable.android_superhero3
        ),
        SuperHero(
            name = R.string.hero4,
            description = R.string.description4,
            image = R.drawable.android_superhero4
        ),
        SuperHero(
            name = R.string.hero5,
            description = R.string.description5,
            image = R.drawable.android_superhero5
        )
    )
}

@Composable
fun SuperHeroLists() {
    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(getData()) {
            SuperHeroItem(superHero = it)
        }
    }
}

@Composable
fun SuperHeroItem(modifier: Modifier = Modifier, superHero: SuperHero) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .weight(3f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = superHero.name),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(id = superHero.description),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Image(
            painter = painterResource(id = superHero.image),
            contentDescription = stringResource(id = superHero.description),
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SuperHeroAppTheme {
        SuperHeroLists()
    }
}