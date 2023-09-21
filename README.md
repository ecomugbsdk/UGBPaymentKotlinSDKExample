# UGBPaymentKotlinSDKSource


# Requirements
API 28+


# SDK configuration
Init the UGBPaymentKotlinSDKSource library. 

First nead use implementation

```kotlin
implementation("com.ukrgasbank.ecom:ugbpaymentkotlinsdk:0.0.1")
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
implementation("com.google.android.gms:play-services-wallet:18.1.2")
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


#  Prepare payment data for sending:
a) Create `MerchantConfig` object that contains merchant data settings

```kotlin
val merchantConfig = MerchantConfig(
    apiKey = "653f06d1-208f-447a-90f5-a2e653f28b8d",
    merchantName = "prod_test"
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
  transactionConfig = transactionConfig
)
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

