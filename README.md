# IDLA
iOS Developer Learning Android

![](https://i.imgur.com/82zRZx8.png)

此為2020第11屆IT邦幫忙鐵人賽Mobile Development組參賽系列文章(寫於2019年)

是一個蘋果工程師學習安卓的過程

因文章與程式碼都為當日現做

故有commit message與文章對不起來的情況

以下方介紹為準

---

[Lesson 01 - Android Studio](https://ithelp.ithome.com.tw/articles/10215881)
* 大致介紹了AS的板面配置: [像這樣](https://i.imgur.com/KcnMkKa.jpg)
* 最大的差別在於Android有`規定各種檔案存放的路徑`
* 再來以前Xcode只有一個Consolo，`AS分成Log、Build、Run`
* 要執行除錯模式`斷點才會停`

[Lesson 02 - Hello World](https://ithelp.ithome.com.tw/articles/10216127)
* Log`有分類型`v,d,i,w,e，分別對應Verbose,Debug,Info,Warn,Error
* 模擬器要自己下載
* 實機要啟用`開發者模式`

[Lesson 03 - 專案相關設定](https://ithelp.ithome.com.tw/articles/10217033)
* `AndroidManifest 跟 Gradle`是Android兩個`很重要`的設定檔，類似xcodeproj
* Gradle有類似podfile可以`裝套件`
* 另外這集有講怎麼設定`icon跟Target`

[Lesson 04 - Activity生命週期](https://ithelp.ithome.com.tw/articles/10217597)
* Activity就是`類似ViewController`的東西
* 因為他們`沒有NavigationController`，所以要切換Activity要透過`Intent`去call startActivity(類似present)
* life cycle對照表

| iOS | Android |
| -------- | -------- | 
|VDL	|onCreate
|WillEnterForeground	|onRestart
|VWA, DidBecomeActive	|onStart
|VDA	|onResume
|VWD, WillResignActive	|onPause
|VDD, DidEnterBackground	|onStop
|dealloc	|onDestroy

[Lesson 05 - Activity啟動模式](https://ithelp.ithome.com.tw/articles/10217624)

![](https://i.imgur.com/IGjEM4J.gif)
* 就是決定`要不要new一個新的Activity`
* Standard: 不管怎樣都一定產生一個新的Activity出來。
* Single Top: 如果要去的Activity已經在Task的Top的話，就直接拿來用，不然的話才new。
* Single Task: 該Task只有一個Activity，如果Task已存在就pop回去，中間的Activity就都出棧。
* Single Instance: 比照Single Task，有就pop，沒有才new，但會new在另一條Task

[Lesson 06 - 如何製作畫面](https://ithelp.ithome.com.tw/articles/10218445)
* 可以用拉的，AS會`自動產生XML`
* XML是`人類看得懂`的，也可以自己寫XML，寫的時候可以`即時預覽`
* 也可以用Java寫畫面

[Lesson 07 - Layout](https://ithelp.ithome.com.tw/articles/10218463)

![](https://i.imgur.com/lksBwpF.gif)
* 類似self.view地位，但會`安排subView的位置`，主要這三種：
* Linear Layout: 畫面很簡單的時候用
* Relative Layout: 以前比較常用，現在應該都用ConstraintLayout
* Frame Layout: Fragment會用到

[Lesson 08 - ConstraintLayout基礎](https://ithelp.ithome.com.tw/articles/10219551)
* 就是`類似AutoLayout`的東西，介紹基本用法

[Lesson 09 - ConstraintLayout特色](https://ithelp.ithome.com.tw/articles/10219557)
* Guideline: 輔助線，可以拿來算比例
* `Chain`: 把多個物件串起來，自動分配位置(像stackView)，但好用很多
* `gone`: 物件不顯示了，而且位置還會被其他元件替補
* CircleAngle: 可以用角度去算

[Lesson 10 - TextView + EditText](https://ithelp.ithome.com.tw/articles/10220496)

![](https://i.imgur.com/aVldqlK.gif)

| Android | iOS |
| -------- | -------- |
| TextView | UILabel    |
| EditText | UITextField |
* 不用寫code就可做到`跑馬燈跟`UITextView`自動長高`

[Lesson 11 - Button + Dialog](https://ithelp.ithome.com.tw/articles/10220529)

| Android | iOS |
| -------- | -------- |
| Button | UIButton    |
| Dialog | UIAlertController |
* 基本上Android的元件事件都是用監聽(setOnXXXXXListener)給他一個Closure
* Alert可以用鏈式寫法一路點下去`很爽`
* 有個小提示叫做`Toast`，可以顯示訊息給user

[Lesson 12 - ImageView + ImagePicker](https://ithelp.ithome.com.tw/articles/10220568)

| Android | iOS |
| -------- | -------- |
| ImageView | UIImageView |
| Bitmap | UIImage |
* `圖片檔名`連一個大寫都不能出現= =，不然就會build不起來
* `scaleType`就是以前的UIContentMode
    1. UIViewContentModeScaleToFill = fitXY
    2. UIViewContentModeScaleAspectFit = fitCenter
    3. UIViewContentModeScaleAspectFill = centerCrop
* 圖片可能會被轉90度，`還不知道怎麼解！！！`
* 模擬器可以測相機

[Lesson 13 - Spinner + DatePickerDialog](https://ithelp.ithome.com.tw/articles/10220569)

![](https://i.imgur.com/pO9J9jh.gif)

| Android | iOS |
| -------- | -------- |
| Spinner | UIPickerView    |
| DatePickerDialog | UIDatePicker |

[Lesson 14 - SeekBar + ProgressBar](https://ithelp.ithome.com.tw/articles/10220570)

![](https://i.imgur.com/foxrRXT.gif)

| Android | iOS |
| -------- | -------- |
| ProgressBar | UIActivityIndicatorView |
| SeekBar | UISilder |
* `Loading轉圈`動畫是用ProgressBar

[Lesson 15 - Buttons = [Radio,Chip,Switch,Toggle,Material]](https://ithelp.ithome.com.tw/articles/10220571)

![](https://i.imgur.com/m5g4WgG.gif)

| Android | iOS |
| -------- | -------- |
| RadioButton | UISegment |
| Switch | UISWitch |
| ToggleButton | 無 |
| Chip | 無 |
| MaterialButton | UIButton |
* `Chip`可以做到常見的tag或是Mail收件人功能
![](https://i.imgur.com/p791Tti.png)

[Lesson 16 - RecyclerView](https://ithelp.ithome.com.tw/articles/10223156)

![](https://i.imgur.com/mpp9AiZ.gif)
* 以前都用`ListView`，但不像TableView有回收的機制，後來就出了個`RecyclerView`
* iOS的Delegate跟DataSource，在安卓世界裡要用個`RecyclerView.Adapter`來處理`三個必做的方法`
    1. onCreateViewHolder(給它畫面)
    2. onBindViewHolder(給它資料或監聽點擊)
    3. getItemCount(資料筆數) 
* Adapter裡面要有個`RecyclerView.ViewHolder`負責持有畫面跟更新資料

[Lesson 17 - BottomNavigationView + Fragment](https://ithelp.ithome.com.tw/articles/10223927)

![](https://i.imgur.com/CGKPySl.gif)
* BottomNavigationView做出來會`像TabBarController`，但是很像View上面放幾個按鈕然後把subView換掉的感覺
* 我的理解：因為Android不像iOS可以ViewController addChildViewController，所以他們發明了`可以加在Activity上的東西：Fragment`
因此iOS上常見的ContainerViewController模式到的Android上就要請Fragment出馬了

[Lesson 18 - call API](https://ithelp.ithome.com.tw/articles/10224409)

![](https://i.imgur.com/uv2NF3R.gif)
* 用`OkHttp`套件
* manifest要加`<uses-permission android:name="android.permission.INTERNET" />`，不然會閃退
* 由三大部分`OkHttpClient, Request, Call`組成一次網路請求
* callback裡動UI要用`runOnUiThread`包起來

[Lesson 19 - JSON轉物件](https://ithelp.ithome.com.tw/articles/10224793)

![](https://i.imgur.com/YM1Tj0r.gif)
* 用`Gson`套件
* 一行搞定：XXXClass xxxInstance = new Gson().fromJson(jsonString,XXXClass.class);
* `@SerializedName`可以跟後端的欄位命名匹配

[Lesson 20 - Activity Gallery](https://ithelp.ithome.com.tw/articles/10225142)

[不知道為什麼有些圖在github上看不到...點我開啟](https://i.imgur.com/oYmMInP.gif)
* `內建`一些範本可以參考或修改
* Drawer: 漢堡側邊欄
* Tabbed: 左右滑動切換頁面
* Master/Detail: SplitViewController
* FullScreen: 就是不會看到安卓系統下面的那條

[Lesson 21 - 指紋辨識](https://ithelp.ithome.com.tw/articles/10225552)

![](https://i.imgur.com/mC7Nitx.gif)
* 在manifest加上權限申請 `<uses-permission android:name="android.permission.USE_FINGERPRINT" />`
* FingerprintManager: 檢查跟辨識使用
* CancellationSignal: 取消辨識使用
* 另外說明了怎麼設定才能在模擬器上測指紋

[Lesson 22 - Google Map](https://ithelp.ithome.com.tw/articles/10225921)

[不知道為什麼有些圖在github上看不到...點我開啟](https://i.imgur.com/GW9eGeB.gif)
* 要去Google API網站申請`API Key`才能用
* 用`getSystemService(Context.LOCATION_SERVICE)`取得locationManager
* 用locationManager.requestLocationUpdates去定位
* 用locationManager.removeUpdates(this)停止定位
* 用mMap.animateCamera(cameraUpdate)去移動位置

[Lesson 23 - 本地儲存](https://ithelp.ithome.com.tw/articles/10226265)

![](https://i.imgur.com/oswYc8g.gif)
* 用`SharedPreferences`(類似UserDefault)
* 有file的概念，可以開很多個xml檔，不像我們只有一個.plist

[Lesson 24 - Room](https://ithelp.ithome.com.tw/articles/10226611)

[不知道為什麼有些圖在github上看不到...點我開啟](https://i.imgur.com/F7FM9PT.gif)
* 是個Google官方提供的套件
* 用來存取SQLite達到本地資料庫的CRUD
* 分成三個Class：`Entity`(就是Model)、`DAO`(負責新刪改查)、`Database`(存資料的地方)
* AS的`Device File Explorer`可以導出資料庫

[Lesson 25 - ActionBar](https://ithelp.ithome.com.tw/articles/10226976)

![](https://i.imgur.com/bgZKPhm.gif)
* 就是上面那條`NavigationBar的位置`
* 改成客製：style.xml的DarkActionBar改成`NoActionBar` > findviewbyID取得layout上的ActionBar > setSupportActionBar
* 沒有改成NoActionBar就setSupportActionBar = `閃退`
* 客製ActionBar就是`Activity上`的一個view

[Lesson 26 - FCM Notification](https://ithelp.ithome.com.tw/articles/10227253)

![](https://i.imgur.com/UCU3S0r.gif)
* FCM = `Firebase Cloud Messaging`
* 已整合進AS(在Tools裡可以找到)
* `不用`取得user權限也可收推播
* 實作繼承FirebaseMessagingService的Service去override onMessageReceived
* `不像iOS一定要走APNs`，他們也可以不透過FCM，像在中國Google不通，就要用其他的推播服務

[Lesson 27 - APP Widget](https://ithelp.ithome.com.tw/articles/10227564)

[不知道為什麼有些圖在github上看不到...點我開啟](https://i.imgur.com/gTo3Av1.gif)
* Android的widget`繼承於BroadcastReceiver`
* 生命週期：onEnabled(加入第一個widget時呼叫)、onUpdate(只要加入widget時就會呼叫)、onDeleted(只要刪除widget時就會呼叫)、onDisabled(刪除最後一個widget時呼叫)
* onReceive：因為是繼承BroadcastReceiver，所以也可以發廣播給它
* 佈局`只支援`FrameLayout、LinearLayout、RelativeLayout、GridLayout
* 元件`只支援`AnalogClock、Button、Chronometer、ImageButton、ImageView、ProgressBar、TextView、ViewFlipper、ListView、GridView、StackView、AdapterViewFlipper(`連子類也不行`)
* widget跟畫面的溝通必須要透過一個`RemoteViews`類來處理

[Lesson 28 - 伸縮Banner + 瀑布流 + CardView](https://ithelp.ithome.com.tw/articles/10227863)

[不知道為什麼有些圖在github上看不到...點我開啟](http://fp1.fghrsh.net/2019/10/16/380d897ae28a99943fa14db5049790ec.gif)
* `CardView`: 就是FrameLayout的一種，但是加了一些現在常用的設計，例如圓角/陰影等等
* 瀑布流: 給RecycleView一個`StaggeredGridLayoutManager`就OK了，超簡單
* 伸縮Banner: 透過`CoordinatorLayout`跟CollapsingToolbarLayout即可達成～不用寫code
* 在AndroidMenifest把Activity的label改掉，`會蓋掉app_name`

[Lesson 29 - 上架](https://ithelp.ithome.com.tw/articles/10228139)
* Android的key(憑證)是存在本地的，沒保管好就不能更新架上的APP了(現在Google好像有代管服務了，但沒研究)
* 打包跟送審流程每個步驟都截圖下來了，直接去看吧～
