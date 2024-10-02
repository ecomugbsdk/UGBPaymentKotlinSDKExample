# UGBPaymentKotlinSDKSource


# Requirements
API 23+


# SDK configuration
Init the UGBPaymentKotlinSDKSource library. 

First nead use implementation

```kotlin
implementation("com.ukrgasbank.ecom:ugbpaymentkotlinsdk:0.4.0")
```

You also need to add the necessary dependencies

```kotlin
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("io.ktor:ktor-client-core:2.1.0")
implementation("io.ktor:ktor-client-cio:2.1.0")
implementation("io.ktor:ktor-client-serialization:2.1.0")
implementation("io.ktor:ktor-client-logging-jvm:2.1.0")
implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.2")
implementation("com.google.code.gson:gson:2.8.8")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
implementation ("com.google.android.gms:play-services-wallet:19.4.0")
implementation ("com.google.android.gms:play-services-base:18.5.0")
implementation ("com.google.android.gms:play-services-pay:16.5.0")
```

Add to you Manifest.xml main library Activity

```kotlin
 <activity
        android:name="com.ukrgasbank.ecom.PaymentActivity"
        android:enabled="true"
        android:theme="@style/UGPPaymentSDKTheme" />
```

Add to you .kt file


```kotlin
import com.ukrgasbank.ecom.UGBPaymentSDK
import com.ukrgasbank.ecom.AmountConfig
import com.ukrgasbank.ecom.TransactionConfig
import com.ukrgasbank.ecom.MerchantConfig
import com.ukrgasbank.ecom.PaymentAction
import com.ukrgasbank.ecom.PaymentData
import com.ukrgasbank.ecom.ResultData
import com.ukrgasbank.ecom.Environment
import com.ukrgasbank.ecom.GooglePayConfig
```


For example to use in project:

```kotlin
private let ugbPaymentSDK = UGBPaymentkotlinSDK()
```

**Environment**:  

```kotlin
enum class Environment {
  DEVELOPMENT,
  PRODUCTION
}
```

<br>


# Customization 

You can easily customize the payment screen colors/texts.
The colors table:


```kotlin

  <!-- Colors for ButtonPay -->
  <color name="button_pay_enabled_color">#212529</color>
  <color name="button_pay_disabled_color">#cad4dd</color>
  <color name="button_pay_text_color">#ffffff</color>

  <!-- Colors and Fonts for InfoText -->
  <color name="info_text_background_color">#00000000</color> <!-- clear -->
  <color name="info_text_color">#000000</color> <!-- black -->

  <!-- Colors for PaymentSummary -->
  <color name="summary_background_color">#ffffff</color>
  <color name="summary_text_color">#212529</color>
  <color name="summary_separator_color">#E7F0F7</color>

  <!-- Colors for TextFields and Labels -->
  <color name="text_field_color">#000000</color>
  <color name="text_field_placeholder_color">#9E9E9E</color>
  <color name="text_field_active_border_color">#212529</color>
  <color name="text_field_inactive_border_color">#9E9E9E</color>
  <color name="text_field_label_text_color">#000000</color>

  <!-- Colors for AlertText -->
  <!-- Note: Gradient colors are complex and need to be set programmatically. XML does not support gradient definitions. -->

  <color name="alert_background_color">#ffffff</color>
  <color name="alert_emoji_label_color">#000000</color>
  <color name="alert_text_label_color">#000000</color>

  <!-- Colors for NavigationButton -->
  <color name="navigation_button_color">#000000</color>

  <!-- Colors for MyViewController -->
  <color name="view_background_color">#E7F0F7</color>

  <!-- Colors for LoaderLongPollingManager -->
  <color name="loader_dimming_background_color">#66000000</color> <!-- Black with 40% opacity -->
  <color name="loader_stroke_color">#E7F0F7</color>

  <!-- Colors for LongPollingManager's modals -->
  <color name="modal_view_success_background_color">#66000000</color>
  <color name="modal_view_error_background_color">#66000000</color>

  <!-- Colors for ModalErrorViewController -->
  <color name="error_result_view_background_color">#E7F0F7</color>
  <color name="error_result_default_background_color">#FFFFFF</color>
  <color name="error_result_shadow_color">#000000</color>
  <color name="error_result_label_color">#000000</color>
  <color name="error_result_button_border_color">#000000</color>
  <color name="error_result_button_title_color">#000000</color>
  <color name="error_result_button_background_color">#FFFFFFFF</color>

  <!-- Colors for ModalSuccessViewController -->
  <color name="success_result_view_background_color">#E7F0F7</color>
  <color name="success_result_default_background_color">#FFFFFF</color>
  <color name="success_result_shadow_color">#000000</color>
  <color name="success_result_label_color">#000000</color>
  <color name="success_result_button_title_color">#000000</color>
  <color name="success_result_button_border_color">#000000</color>
  <color name="success_result_button_background_color">#FFFFFFFF</color>

  <color name="bottom_panel_with_logos_color">#ffffff</color>
  
  <color name="alert_gradient_start_color">#e9ddd4</color>
  <color name="alert_gradient_end_color">#887cae</color>
```

The texts table:


```kotlin
 <!-- Texts for PayButton -->
  <string name="button_pay_enabled_text_string">Сплатити</string>
  <string name="button_pay_disabled_text_string">Сплатити</string>

  <!-- Texts for InfoText -->
  <string name="info_text_string">Транзакція обробляється ПАТ «УКРГАЗБАНК». Натискаючи «Сплатити», ви погоджуєтесь з умовами Публічної оферти. Виникли питання?</string>

  <!-- Texts for PaymentSummary -->
  <string name="sum_label_text_string">Сума до сплати:</string>
  <string name="commission_label_text_string">Комісія платіжної компанії:</string>
  <string name="total_label_text_string">Загалом:</string>

  <!-- Texts for TextFields and Labels -->  
  <string name="card_number_placeholder_string">0000 0000 0000 0000</string>
  <string name="expiry_date_placeholder_string">Місяць/Рік</string>
  <string name="cvv_placeholder_string">XXX</string>
  <string name="card_number_label_string">Номер картки</string>
  <string name="expiry_date_label_string">Строк дії</string>
  <string name="cvv_label_string">Код CVV</string>
  <string name="toolbar_done_button_string">Done</string>

  <!-- Texts for AlertText -->
  <string name="alert_text_string">Дія не зберігає ваші платіжні дані.</string>
  <string name="alert_emoji_string">☝️</string>

  <!-- Texts for NavigationButton -->
  <string name="navigation_button_string">Разовий платіж карткою</string>

  <!-- Texts for ModalSuccessViewController -->
  <string name="success_emoji_string">👍</string>
  <string name="success_message_string">Дякуємо, кошти зараховно</string>
  <string name="success_hint_string">Кошти успішно зараховано на рахунок Національного банку України</string>
  <string name="continue_button_title_string">Продовжити</string>

  <!-- Texts for ModalErrorViewController -->
  <string name="error_emoji_string">😟</string>
  <string name="error_message_string">Платіж не виконано</string>
  <string name="error_hint_string">Зверніться до банку, що видав картку</string>
  <string name="error_button_title_string">Продовжити</string>
```


#  Prepare payment data for sending(paymentLauncherShow):
a) Create `MerchantConfig` object that contains merchant data settings

```kotlin
val merchantConfig = MerchantConfig(
    apiKey = "653f06d1-208f-447a-90f5-a2e653f28b8d",
    merchantName = "prod_test",
    sessionToken = "h.b.s"  // in format JWT (below is a specification of creating a signature)
)
```

b) Create `AmountConfig` object that contains amount data settings

```kotlin
val amountConfig = AmountConfig(
    amount = "1.00",
    currency = "UAH"
  )
```

Please use format amount how present in example to correct work!

c) Create `TransactionConfig` object that contains transaction data settings

```kotlin
val transactionConfig = TransactionConfig(
    orderID = generateOrderID(),
    action = PaymentAction.PURCHASE
  )
```

d) Create `PaymentData` object that contains all settings for you payment

```kotlin
val paymentData = PaymentData(
  merchantConfig = merchantConfig,
  amountConfig = amountConfig,
  transactionConfig = transactionConfig,
  googlePayConfig = GooglePayConfig(...), // null by default
)
```

e) If you need use GooglePay in your project nead initialize config

```kotlin
val paymentData = PaymentData(
  merchantConfig = merchantConfig,
  amountConfig = amountConfig,
  transactionConfig = transactionConfig,
  googlePayConfig = GooglePayConfig(
    merchantName = "Ukrgasbank",
    merchantId = "BCR2DN6TQ8Y730K1",
    environment = Environment.DEVELOPMENT  // Environment.PRODUCTION
  )
)
```

#  Prepare payment data for sending(paymentLauncherShow):
a) Create json data to sending, it will contain payment information

```kotlin
var paymentDataString : String = "{\n" +
      "  \"paymentData\": {\n" +
      "    \"paymentToken\": \"eyJhbGciOiJSUzI1kpXVCJ9.ekYXRhIjoie1wib3JkZXJJZFwiOlwiRE9ONzUxMTc5NDYwNDgyNDZcIixcImFtb3VudFwiOjEwMCxcImZlZVwiOjAsXCJ1c2VySWRcIjpcIjU3NGZkMGNlYzEyYTA4NjVjNDJmOWUzOGNmMTllZDlmMmE3YTAwZWRmZjBmOGJkZjQ1N2M1NTU1ZWEwYTA2ZWIwMzNjOWQ4Njc1MWQxNDk3ZDU2ZTg2NTgwM2M4MTU3YjY4NjhiOTY3ZDIzZDQwZDM3YjZhZGZiMmVmY2M5MTgzXCIsXCJkZXNjcmlwdGlvblwiOlwi0JHQu9Cw0LPQvtC00ZbQudC90LAg0LTQvtC_0L7QvNC-0LPQsCDQstGW0LnRgdGM0LrQvtCy0L7RgdC70YPQttCx0L7QstGG0Y_QvFwiLFwiXCI6XCIyMDI0LTA5LTE3VDEzOjQzOjI3LjY0M1pcIixcInVuaXhUaW1lU3RhbXBcIjoxNzI2NTgwNjA4LFwiY3VycmVuY3lcIjpcIlVBSFwiLFwicmVjaXBpZW50c1wiOlt7XCJvcmRlcl9yZWNpcGllbnRfaWRcIjpcIkRPTjc1MTE3OTQ2MDQ4MjQ2XzBcIixcIm1lcmNoYW50X25hbWVcIjpcInUyNF9kZWZlbmNlXCIsXCJiaWxsX3R5cGVcIjpcInUyNF9kZWZlbmNlXCIsXCJhbW91bnRcIjoxMDB9XX0iLCJpYXQiOjE3MjY1ODA2MDcsImV4cCI6MTcyNjU4NzgwN30.CTGhS9BaWQVaQ5nwxIoMzqnRYdoAvVLTPU0EZFI5kIOElRdF7o6m6yCCuTYL2qWNBBFteZBSuhRA77Rcf-9aOYH3QqVpGYRIptqC79vrfmivoG1OxSfFsTDrUoEsizxyCuF4QfpqCm4zFQ0DoXhY7jTpwZZP3CNTt7jGIkn-BMqz7nXOaIT6WWwG73cg6fe-u-Gli2IlfLwaJ-Iw0UXqWNuipHRyaHJMaMe0CbpWy5SyNHctAxCWXJr0BHXFxJLBssnI-Y2Ot2QA-YAXSJxpqhoLJq1xpuQ_XNcFp7wrG-nHiW6N8KJqC-p2S3lMs54puDTTU0rt4g\",\n" +
      "    \"orderId\": \"TEST123456789\",\n" +
      "    \"amount\": 100.00,\n" +
      "    \"merchantId\": \"test_merchant\",\n" +
      "    \"fee\": 0,\n" +
      "    \"userId\": \"574fd0cec12a0865c42f9e38cf19ed9f2a7a00edff0f8bdf457c5555ea0a06eb033c9d86751d1497d56e865803c8157b6868b967d23d40d37b6adfb2efcc9183\",\n" +
      "    \"description\": \"Test Payment\",\n" +
      "    \"initializationDate\": \"2024-09-13T13:43:27.643Z\",\n" +
      "    \"unixTimeStamp\": 1726580608,\n" +
      "    \"currency\": \"UAH\",\n" +
      "    \"recipients\": [\n" +
      "      {\n" +
      "        \"order_recipient_id\": \"TEST123456789_0\",\n" +
      "        \"merchant_name\": \"test_merchant\",\n" +
      "        \"bill_type\": \"test_merchant\",\n" +
      "        \"amount\": 100\n" +
      "      }\n" +
      "    ]\n" +
      "  }\n" +
      "}"
```

b) After you need use this data with apiKey and send request

```kotlin
UGBPaymentSDK.paymentInit(this, paymentDataString, "0b2a1987-934c-437c-a080-9fb65d7f1ecd") {
      resultData : ResultData ->
    }
```

About `resultData` and function callback [information](#handling-payment-status).

# Specification of create JWT Token

This option is required in certain cases. Please contact with the administration about the need to use the token. 

`EXAMPLE RSA PRIVATE KEY` :

```EXAMPLE RSA PRIVATE KEY
-----BEGIN RSA PRIVATE KEY-----
MIIBOAIBAAJBAOOefHCTXucdN4NPA/fOGsQb608NsKEKNPncwxqu4rfutk4jcORF
G7KwRtBj/b+mPRXJ5xZgYK582/2o9xxYPWcCARECQELyYNXQ/cuBEFPL8hu1Fu5i
kICprGuZlxxP/SX3M5+B48vymQjaVefWtZ4oZ6GOip1aky7GjCjnzojVx4Il47kC
IQD4ooQSHDteYGAsOzeILuBsPCukOIWnnO7zE3dVuzvKpQIhAOpcmbzdI2YK3H3h
1khresZcNxs+0ULs4CqyjfsNAgYbAiAr4HGo18491MWtc9yfj81ARtqGZFPSSN7f
mgYAEft+HQIgNyTY4ST5RS+7aOnYEQo7AX8cBmkiLd1h6+3HDeTxatkCIQDVQrAy
6mGv7R9k07tA7qRnaoHI30t63VY65zgHAcJj2g==
-----END RSA PRIVATE KEY-----
```

`EXAMPLE HEADER for JWT` :

```json
{
    "alg": "RS256",
    "typ": "JWT"
}
```

`EXAMPLE DATA for JWT` :

```json
{
    "merchant_name": "prod_test",
    "order_id": "123456789TEST",
    "timestamp": "171213770346961"
}
```

If you used the correct settings and data to generate the signature, you will end up with a token like this based on the data above:

```
eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZXJjaGFudF9uYW1lIjoicHJvZF90ZXN0Iiwib3JkZXJfaWQiOiIxMjM0NTY3ODlURVNUIiwidGltZXN0YW1wIjoiMTcxMjEzNzcwMzQ2OTYxIn0.xyJ35F3L7RxQmWYOFymXR05UmNcR036yBxD82qWtBvWQsQo1m2FUtXGnJup3RqEiO3zHKC_s1TJq1JZfehpTaA
```


# Make a request for payment processing

```kotlin
UGBPaymentSDK.paymentLauncherShow(
      this,
      SuccessActivity::class.java,
      ErrorActivity::class.java,
      Environment.DEVELOPMENT,
      paymentData) { resultData: ResultData -> 
}
```

If you nead forward to previous screen you nead use null values to Error/Success activity, example: 

```kotlin
UGBPaymentSDK.paymentLauncherShow(
      this,
      null,
      null,
      Environment.DEVELOPMENT,
      paymentData) { resultData: ResultData -> 
}
```


<br>

# Handling payment status

You can use callback function from initialise you payment

```kotlin
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
```
> You get data when payment getting finnaly status

`PaymentInfoResponse` :
|Parameter    | Description |
| ----------- | ----------- |
|status| Transaction status|
|description	|Payment description|
|rrn| Unique identifier in processing|
|errorCode| SDK payment status code|
|order_id| Unique identifier of order you set|
|currency|	Transaction currency (ISO_4217)|
|termID| Payment termina under which the operation was performed|
|amount	| Transaction amount|
|timestamp |	Timestamp when transaction get finnaly status|
|transactionReference |	Reference your transaction|
|||




# Versions

`Update history` :
| Date    | Version | Description |
| ----------- | ----------- | ----------- |
| 05.04.2024 | 0.0.3 | Minor fixing bug |
| 12.09.2024 | 0.1.0 | Add suuport GPAY |
| 23.09.2024 | 0.2.0 | Add support function init - paymentInit |
| 27.09.2024 | 0.2.1 | Minor fixing bug |
||||
