package com.ukrgasbank.ugbpaymentkotlinsdkexample


import android.os.Bundle
import androidx.activity.ComponentActivity

import com.ukrgasbank.ecom.UGBPaymentSDK
import com.ukrgasbank.ecom.AmountConfig
import com.ukrgasbank.ecom.TransactionConfig
import com.ukrgasbank.ecom.MerchantConfig
import com.ukrgasbank.ecom.PaymentAction
import com.ukrgasbank.ecom.PaymentData
import com.ukrgasbank.ecom.ResultData
import com.ukrgasbank.ecom.Environment



class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


    val merchantConfig = MerchantConfig(
      apiKey = "653f06d1-208f-447a-90f5-a2e653f28b8d",
      merchantName = "prod_test"
    )
    val amountConfig = AmountConfig(
      amount = "1.00",
      currency = "UAH"
    )

    val transactionConfig = TransactionConfig(
      orderID = generateOrderID(),
      action = PaymentAction.PURCHASE
    )


    val paymentData = PaymentData(
      merchantConfig = merchantConfig,
      amountConfig = amountConfig,
      transactionConfig = transactionConfig
    )


    UGBPaymentSDK.paymentLauncherShow(
      this,
      SuccessActivity::class.java,
      ErrorActivity::class.java,
      Environment.DEVELOPMENT,
      paymentData) { resultData: ResultData ->

      println("ResultData status: ${resultData.status}")

      resultData.description?.let {
        println("ResultData description: $it")
      } ?: println("ResultData description is nil")

      resultData.rrn?.let {
        println("ResultData rrn: $it")
      } ?: println("ResultData rrn is nil")

      resultData.errorCode?.let {
        println("ResultData errorCode: $it")
      } ?: println("ResultData errorCode is nil")

      resultData.orderID?.let {
        println("ResultData orderID: $it")
      } ?: println("ResultData orderID is nil")

      resultData.currency?.let {
        println("ResultData currency: $it")
      } ?: println("ResultData currency is nil")

      resultData.termID?.let {
        println("ResultData termID: $it")
      } ?: println("ResultData termID is nil")

      resultData.amount?.let {
        println("ResultData amount: $it")
      } ?: println("ResultData amount is nil")

      resultData.timestamp?.let {
        println("ResultData timestamp: $it")
      } ?: println("ResultData timestamp is nil")

      resultData.transactionReference?.let {
        println("ResultData transactionReference: $it")
      } ?: println("ResultData transactionReference is nil")
    }

  }

  fun generateOrderID(): String {
    val timestamp = System.currentTimeMillis()
    return "$timestamp"
  }

}
