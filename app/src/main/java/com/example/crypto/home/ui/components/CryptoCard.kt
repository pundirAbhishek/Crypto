package com.example.crypto.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.crypto.R
import com.example.crypto.data.model.Crypto
import com.example.crypto.ui.theme.*
import com.example.crypto.utils.LineChart


//fun CryptoCard(crypto: Crypto, modifier: Modifier = Modifier)


@Composable
fun CryptoCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(20.dp))
            .width(200.dp)


    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            cardFirstColor,
                            cardSecondColor
                        )
                    )
                )
                .padding(horizontal = 20.dp, vertical = 16.dp)

        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Ethereum")
                Text(text = "Eth")
            }

            val data = chartData.map {
                it.toFloat()
            }.subList(0, (chartData.size * 0.2).toInt())

            LineChart(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                yAxisValues = data,
                lineColors = listOf(Color.White, Color.White)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(1f)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.eth),
                    contentDescription = "Crypto Logo",
                    modifier = Modifier.size(60.dp)
                )

                Column {
                    Text(text = "Profit")
                    Text(text = "2.6%")
                    Text(text = "$14.580,00")
                }
            }

        }
    }
}

@Preview
@Composable
fun CryptoCardPreview() {
    CryptoCard()
}

val chartData = listOf(
    47805.919122945335,
    46961.79972269094,
    47630.962699585376,
    47990.30662393907,
    48197.198418057065,
    47787.73135072662,
    47682.67097827655,
    47568.05008961924,
    47381.385491713634,
    47514.571214716816,
    47343.50123202143,
    47396.27696404345,
    46574.822812744154,
    46870.91036460079,
    46747.58983309426,
    46689.116488841966,
    46629.02543464945,
    46856.16890311356,
    46767.75356330842,
    47168.13938113987,
    47211.709862595446,
    46951.23151241522,
    46864.62008787697,
    47057.70281606071,
    47742.5906468732,
    47577.89794803823,
    47344.508414679105,
    47489.32411491324,
    47238.78970085985,
    47859.83459240028,
    47759.61113268076,
    47944.91401310498,
    47603.68451151897,
    47228.92467658477,
    47332.71953295333,
    47092.11075726091,
    47191.86838983951,
    47105.561773858455,
    47217.56331957398,
    47092.89203548766,
    47335.61290809549,
    47451.89795949327,
    47387.636501091554,
    47499.54733428625,
    47133.91094614981,
    48634.694886516525,
    48373.12539109518,
    48028.847138973324,
    48022.19127557452,
    48082.40689845172,
    47991.45773448097,
    48123.361948995815,
    47985.30217405466,
    47506.6470473304,
    47040.67378897002,
    46608.21450723593,
    45987.22577250991,
    45921.91045525004,
    46399.793258729136,
    46422.82421829218,
    46319.65108805251,
    46839.47878474922,
    46810.963179097256,
    46880.270560921956,
    46907.544324048016,
    46874.72616860012,
    47372.20188855974,
    47128.84846258759,
    47292.77894704173,
    47251.88339845378,
    47223.10399011116,
    46983.08070371822,
    46910.83569536613,
    47197.886158779846,
    47061.02512806555,
    46990.94352769139,
    47415.35862180871,
    47349.33079936147,
    48033.24524853784,
    47648.65771725354,
    47369.35129824658,
    47490.06590552899,
    47340.45407886995,
    47506.77271139331,
    47816.07767640849,
    47692.33640374206,
    47375.627099610865,
    47482.13610264429,
    47413.90762232771,
    46756.895153819445,
    47119.60524023305,
    47261.452584927916,
    47201.760364670234,
    47259.2193624947,
    47409.44527855594,
    47298.50596055617,
    47302.32179185509,
    47407.279144580985,
    47230.03185264002,
    47186.1497235476,
    47424.86500313072,
    47861.45540520053,
    47407.767815864674,
    47057.08580499125,
    47018.022036234026,
    47102.22047293177,
    47120.20461553991,
    47406.93841683391,
    47371.10779061876,
    47121.00186687132,
    47151.72659610956,
    47036.67520222963,
    46888.88228061528,
    46903.04756692963,
    47233.56387931179,
    46981.664000279,
    47102.92390881105,
    47062.68943837382,
    47029.81194456035,
    47225.995364420975,
    47503.7562114244,
    47238.06788109148,
    47290.00625222793,
    46891.233939562626,
    46755.24757658214,
    46535.57748297065,
    46728.74918128138,
    46548.370425069,
    46393.98638742354,
    45966.43984703932,
    46155.15631143342,
    46280.98326476368,
    46531.140860530526,
    46235.884365682046,
    46135.91582075914,
    46206.74797556233,
    46457.5611752291,
    46109.14600772337,
    46194.244879141836,
    46465.75216608625,
    46660.94899372711,
    46491.7299974738,
    46379.43752784,
    46889.481956170144,
    46803.15078633856,
    46591.722409635506,
    47057.02449635822,
    47507.693656884665,
    47066.565769064786,
    46904.77628067637,
    46664.62988762414,
    45794.698823411105,
    45998.57774647676,
    46346.54389040857,
    46294.00598439383,
    46164.78138780403,
    45938.02427172366,
    46309.780484451265,
    46243.70671169548,
    46370.15671395653,
    46519.15292800913,
    46405.09737517141,
    46368.51184567423,
    46520.72301190721,
    46442.61044066538,
    46718.281511878595,
    46928.9216580707,
    46807.334592906205
)

