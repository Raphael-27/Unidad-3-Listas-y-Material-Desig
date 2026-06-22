package com.example.videojuegos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview  // ← MOVIDO AQUÍ
import androidx.compose.ui.unit.dp
import com.example.videojuegos.ui.theme.VideojuegosTheme

data class Game(
    val titulo: String,
    val plataforma: String,
    val imagen: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            VideojuegosTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    ListaJuegos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ListaJuegos(modifier: Modifier = Modifier) {

    val juegos = listOf(
        Game("Minecraft", "PC / Android", R.drawable.minecraft),
        Game("Fortnite", "PC / Consolas", R.drawable.fortnite),
        Game("Valorant", "PC", R.drawable.valorant),
        Game("Roblox", "Multiplataforma", R.drawable.roblox),
        Game("Among Us", "Android / PC", R.drawable.amongus),
        Game("Five Nights at Freddy's", "PC / Android", R.drawable.fnaf),
        Game("Halo", "Xbox / PC", R.drawable.halo),
        Game("FC 26", "PlayStation / Xbox", R.drawable.fc),
        Game("GTA VI", "PlayStation / Xbox", R.drawable.gtasix),
        Game("Free Fire", "Android", R.drawable.freefire)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(juegos) { juego ->
            TarjetaJuego(juego)
        }
    }
}

@Composable
fun TarjetaJuego(game: Game) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Image(
                painter = painterResource(id = game.imagen),
                contentDescription = game.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = game.titulo,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = game.plataforma,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListaJuegos() {
    VideojuegosTheme {
        ListaJuegos()
    }
}