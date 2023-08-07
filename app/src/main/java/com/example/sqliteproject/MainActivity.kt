package com.example.sqliteproject

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sqliteproject.ui.theme.SqliteProjectTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Peter Parker:", "Es el Spider-Man original y el más conocido. Fue creado por Stan Lee y Steve Ditko en 1962. Peter es un estudiante de secundaria que adquiere habilidades arácnidas después de ser mordido por una araña radiactiva. Es conocido por su ingenio, su sentido del humor y su gran corazón."),
    MyMessage("Ben Reilly", "¿También conocido como el \"Hombre Araña Escarlata\", Ben Reilly es un clon de Peter Parker creado por el villano Miles Warren. Ben asumió el manto de Spider-Man después de que Peter se retirara temporalmente. Ben es conocido por su traje escarlata y su cabello rubio."),
    MyMessage("Miles Morales:", "Miles es un adolescente afroamericano y latino que adquiere habilidades arácnidas después de ser picado por una araña genéticamente modificada. Fue creado por Brian Michael Bendis y Sara Pichelli en 2011. Miles es conocido por su traje negro y rojo y por su habilidad para camuflarse."),
    MyMessage("Miguel O'Hara", "También conocido como Spider-Man 2099, Miguel es un científico del futuro que adquiere habilidades arácnidas después de un experimento fallido. Fue creado por Peter David y Rick Leonardi en 1992. Miguel es conocido por su traje azul y rojo y por su habilidad para trepar por las paredes."),
    MyMessage("Spider-Gwen", "Gwen Stacy es el primer amor de Peter Parker en su universo original, pero en Tierra-65 tiene superpoderes y se mueve tan ágil como el propio Spidey. En este plano de Marvel, Gwen Stacy es mordida por una araña de laboratorio y asume el papel de Peter. Como curiosidad, la versión de Peter Parker de Tierra-65 se convirtió en Lagarto y murió. Sin duda, es una realidad alternativa muy diferente a la que conocemos."),
    MyMessage("Spider-Man Noir", "¿Otro personaje que aparece en Un nuevo Universo es el Spider-Man inspirado en el cine negro. Precisamente, a este universo se le conoce también como Marvel Noir y su historia se desarrolla en los años 30 durante la Gran Depresión. Se trata de un superhéroe más sombrío, cuyo alter ego se llama Ben Urich. Es un reportero experimentado que trabaja en el Daily Bugle que controla una red de informadores bajo el alias de la Araña. Aquí encontrarás una historia llena de conspiraciones, asesinatos y extorsión."),
    MyMessage("Peni Parker", "¿Como puedes intuir, Peni es la versión de Spider-Man más joven. Claro que tiene puntos en común con Peter Parker porque fue adoptada por la tía May y el tío Ben tras la muerte de sus padres. Este personaje fue creado para el evento de Marvel conocido como Spider-Verse y tiene muchas diferencias importante con el héroe original. Principalmente se trata de una niña que maneja el traje mecánico conocido como SP//dr, propiedad de su padre. Está controlado por una araña radiactiva que comparte un vínculo psíquico con el piloto."),
    MyMessage("Spider-Ham", "Spider-Ham proviene de Tierra-8311, un universo donde habitan animales antropomórficos con habilidades especiales. Está en clave de parodia, así que la historia no tiene desperdicio. La araña Peter estaba en el laboratorio de la científica May Porker, pero en un experimento todo se complica y muerde accidentalmente a Peter que se transforma en este simpático personaje."),
    MyMessage("Spider-Punk", "¿Su nombre real es Hobart 'Hobie' Brown, una versión de Tierra-138 que recibió el mordisco de una araña radiactiva de la compañía Osborn tras buscar entre los residuos tóxicos. Aquí Osborn es el presidente y crea una línea depolicías corruptos, por lo que Hobie se convierte en Spider-Punk liderando una rebelión musical para detener los planes malvados del gobernador."),
    MyMessage("Scarlet Spider", "Benjamin 'Ben' Reilly es un clon de Peter Parker que fue creado por un científico loco que solo quería deshacerse del Peter original para hacerse con Spider-Man. También se encuentra en Tierra-616, pero lo genial de este personaje es que a pesar de ser totalmente idéntico a Peter, decide hacer su propio camino sin afectar la vida de su versión original haciéndose llamar Ben Reilly en honor a sus tíos."),
    MyMessage("Spider-Man India", "Pavitr Prabhakar es un chico común y corriente que vive en Mumbai, India, pero todo cambia cuando un día recibe poderes de una araña mística a través de un yogui. A partir de este momento, se convierte en Spider-Man para detener a su némesis, Nalin Oberoi, quien desea invocar a un demonio para conquistar el planeta."),
    MyMessage("Spider-Woman", "Jessica Drew es una de las versiones más conocidas de Spider-Man debido a que ha sido adaptada en animaciones y también cuenta con varias historias interesantes. Sin embargo, en Spider-Man: Across the Spider-Verse se muestra un diseño diferente de ella y además está embarazada mientras usa una moto."),
    MyMessage("Spider-Girl", "May 'Mayday' Parker es la hija de Peter Parker que aparece en Spider-Man: Across the Spider-Verse con los mismos poderes que su padre. Pues bien, esta versión proviene de Tierra-982 y cuando se vuelve adulta se convierte en Spider-Girl, una heroína que solo quiere que la ciudad se mantenga en paz."),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SqliteProjectTheme {
                MyApp()
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Spiderverse 🕸️")
                }
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = (MaterialTheme.colorScheme.background), // Set the desired background color here
                contentColor = MaterialTheme.colorScheme.primary // Set the desired content color here
            ) {
                // Add your BottomNavigationItems here
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text("home")},
                    selected = false,
                    onClick = {}
                )
                /*BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text("fav") },
                    selected = false,
                    onClick = {}
                )*/
                // Add more BottomNavigationItems if needed
            }
        }
    ) {
        Column(modifier = Modifier.padding(top = 64.dp, bottom = 64.dp)) {
            MyMessages(messages)
        }
    }
}


@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) {message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)
        ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.spiderman),
        contentDescription = "Imagen de spiderman",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
    )
}

@Composable
fun MyTexts(message: MyMessage) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(2.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun MyText(text: String, color: Color, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    SqliteProjectTheme {
        MyApp()
    }
}

