package com.example.tugas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugas.ui.theme.TugasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    Welcome()
//                    TryRow()
//                    TryColumn()
//                    TryColumnModifier()
//                    TryAnotherColumnModifier()
//                    TryMakeLogin()
//                    WelcomeScreen()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "homepage") {
                        composable("homepage") {
//                            WelcomeScreen(navController)
                            WelcomeScreenWithScaffold(navController)
                        }
                        composable("pagetwo") {
                            PageTwo(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TugasTheme {
        Greeting("Android")
    }
}

@Composable
fun Welcome() {
    Text(text = "Yafi Yoga Abid Pramono")
}

@Composable
fun TryRow() {
    Row {
        Text(text = "Nama")
        Text(text = "NIM")
    }
}

@Composable
fun TryColumn() {
    Column {
        Text(text = "Program Studi")
        Text(text = "Kelas")
    }
}

@Composable
fun TryColumnModifier() {
    Column {
        Text(text = "Log in")
        Text(text = "Nomor Telepon", modifier = Modifier.padding(24.dp))
        Text(text = "Email")
    }
}

@Composable
fun TryAnotherColumnModifier() {
    val expanded = remember { mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row {
                Text(text = if (expanded.value) "Expanded" else "Not Expanded")
                Text(text = "Row 2")
            }

            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = "Submit")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    val usernameField = remember { mutableStateOf(TextFieldValue("")) }
    val passwordField = remember { mutableStateOf(TextFieldValue("")) }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = usernameField.value,
                onValueChange = {
                    usernameField.value = it
                },
                label = { Text(text = "Username Field") },
                placeholder = { Text(text = "This is placeholder") })
            OutlinedTextField(value = passwordField.value,
                onValueChange = {
                    passwordField.value = it
                },
                label = { Text(text = "Password Field") },
                placeholder = { Text(text = "This is placeholder") })
            Spacer(modifier = Modifier.padding(5.dp))

            ElevatedButton(onClick = { navController.navigate("pagetwo") }) {
                Text(text = "Login")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreenWithScaffold(navController: NavController) {
    val usernameField = remember { mutableStateOf(TextFieldValue("")) }
    val passwordField = remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("BARON")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
//                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Aplikasi Pencari Barber Terdekat",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    )
    { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Silahkan  Log In",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField(value = usernameField.value,
                onValueChange = {
                    usernameField.value = it
                },
                label = { Text(text = "Username Field") },
                placeholder = { Text(text = "This is placeholder") })
            OutlinedTextField(value = passwordField.value,
                onValueChange = {
                    passwordField.value = it
                },
                label = { Text(text = "Password Field") },
                placeholder = { Text(text = "This is placeholder") })
            Spacer(modifier = Modifier.padding(5.dp))
            ElevatedButton(onClick = { navController.navigate("pagetwo") }) {
                Text(text = "Login")

            }
            }
        }
    }

    @Composable
    fun PageTwo(navController: NavController) {
        Text("This is Page Two using Compose UI")
        ElevatedButton(
            onClick = { navController.navigate("homepage") },
            modifier = Modifier.width(20.dp)
        ) {
            Text(text = "Back")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TryMakeLogin() {
        val expanded = remember { mutableStateOf(false) }
        val usernameState = remember { mutableStateOf(TextFieldValue("")) }
        val passwordState = remember { mutableStateOf(TextFieldValue("")) }

        Row(
            horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(value = usernameState.value,
                    onValueChange = {
                        usernameState.value = it
                    },
                    label = { Text(text = "Username") },
                    placeholder = { Text(text = "Your Username") })
                OutlinedTextField(value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Your Password") })
                Spacer(modifier = Modifier.padding(10.dp))
                ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(text = "Submit")
                }
            }
        }
    }





