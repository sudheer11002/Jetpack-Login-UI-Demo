package com.demo.logindemo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.demo.logindemo.R
import com.demo.logindemo.ui.theme.primaryColor


@Composable
fun Login(navController: NavController) {

    val image = imageResource(id = R.drawable.logo)

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {

            Image(image)
        }

            ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(modifier = Modifier.height(120.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email") },
                        placeholder = { Text(text = "Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        onImeActionPerformed = { _, _ ->
                            focusRequester.requestFocus()
                        }
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = vectorResource(id = R.drawable.password_eye),
                                    tint = if (passwordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },

                        label = { Text("Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                        onImeActionPerformed = { _, controller ->
                            controller?.hideSoftwareKeyboard()
                        }

                    )

                    Spacer(modifier = Modifier.padding(30.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                            .clip(RoundedCornerShape(8.dp))


                    ) {
                        Text(text = "Sign In", fontSize = TextUnit.Companion.Sp(16))
                    }

                    Spacer(modifier = Modifier.padding(20.dp))
                    Row{
                        Text(
                            text = "Don't have an account! ",
                            fontSize = TextUnit.Companion.Sp(16),
                            color = Color.Gray)
                        Text(
                            text = "Signup",
                            color = Color.Red,
                            modifier = Modifier.clickable(onClick = {
                                navController.navigate("signup") {
                                    popUpTo = navController.graph.startDestination
                                    launchSingleTop = true
                                }
                            })
                        )
                    }

                    Spacer(modifier = Modifier.padding(20.dp))
                }
            }
        }

    }























