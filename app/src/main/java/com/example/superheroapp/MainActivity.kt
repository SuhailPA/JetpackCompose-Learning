package com.example.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
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
        ), SuperHero(
            name = R.string.hero2,
            description = R.string.description2,
            image = R.drawable.android_superhero2
        ), SuperHero(
            name = R.string.hero3,
            description = R.string.description3,
            image = R.drawable.android_superhero3
        ), SuperHero(
            name = R.string.hero4,
            description = R.string.description4,
            image = R.drawable.android_superhero4
        ), SuperHero(
            name = R.string.hero5,
            description = R.string.description5,
            image = R.drawable.android_superhero5
        ), SuperHero(
            name = R.string.hero1,
            description = R.string.description1,
            image = R.drawable.android_superhero1
        ), SuperHero(
            name = R.string.hero2,
            description = R.string.description2,
            image = R.drawable.android_superhero2
        ), SuperHero(
            name = R.string.hero3,
            description = R.string.description3,
            image = R.drawable.android_superhero3
        ), SuperHero(
            name = R.string.hero4,
            description = R.string.description4,
            image = R.drawable.android_superhero4
        ), SuperHero(
            name = R.string.hero5,
            description = R.string.description5,
            image = R.drawable.android_superhero5
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroLists() {
    Scaffold(topBar = { SuperHeroTopBar() }) { it ->
        LazyColumn(
            contentPadding = it, verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(getData()) { superHero ->
                SuperHeroItem(superHero = superHero)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.titleLarge
        )
    })
}

@Composable
fun SuperHeroItem(modifier: Modifier = Modifier, superHero: SuperHero) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val rotate by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = ""
    )
    Card(modifier = modifier.padding(5.dp)) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp)
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
                        .width(75.dp)
                        .height(75.dp)
                        .clip(MaterialTheme.shapes.large)
                        .clickable { expanded = !expanded }
                        .rotate(rotate),
                    contentScale = ContentScale.Crop,
                )
            }
            if (expanded) {
                ProductExplanation()
            }
        }

    }
}

@Composable
fun ProductExplanation(modifier: Modifier = Modifier) {
    Text(
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make",
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier.padding(10.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SuperHeroAppTheme {
        SuperHeroLists()
    }
}