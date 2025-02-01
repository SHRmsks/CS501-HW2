package com.example.hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw2.ui.theme.HW2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val ingredients: List<String> = listOf("(4 pound) chicken, cut into pieces",  "1 cup buttermilk", "2 cups all-purpose flour for coating", "1 teaspoon paprika", "salt and pepper to taste", "2 quarts vegetable oil for frying")
            HW2Theme {
                card(ingrediants= ingredients)
            }
        }
    }

    @Composable
    fun card(ingrediants: List<String>) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                colors =
                    CardDefaults.cardColors(
                        contentColor = Color(0xffd8ecf2),
                        containerColor = Color(0xff2c7e99),
                    ),
                modifier = Modifier.fillMaxWidth(0.7f).height(300.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chicken),
                        contentDescription = "Fried Chicken",
                        modifier = Modifier.height(100.dp).width(100.dp),
                    )
                    Text(
                        modifier = Modifier,
                        text = "Fried Chicken Recipe",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.font)),
                        fontWeight = W600,
                        color = Color(0xFFcdedf7),
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f).padding(start= 10.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text="Requirements: ", color = Color(0xFFcdedf7), fontFamily = FontFamily(Font(R.font.font)))
                    ingrediants. mapIndexed{index, item ->
                        Text (
                            fontFamily = FontFamily(Font(R.font.font)),
                            text = "${index+1},  $item",
                            modifier = Modifier,
                            color = Color (0xffe0b62b),
                            fontWeight = W400,
                            fontSize = 10.sp,

                        )
                    }




                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun test() {
     MainActivity()
    }
}
