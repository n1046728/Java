Table of Contents
===
* [Data Integrity](#資料完整性-data-integrity)
* [Normalization](#Normalization)
* [ER Model](#er-model)
* [Transaction](#Transaction)
* [Tutorial](https://www.tutorialspoint.com/dbms/er_model_basic_concepts.htm)
* [NoSQL](#NoSQL)  

## 資料完整性 Data Integrity
確保資料的正確性與可靠性。  
#### 實體完整性Entity Integrity  
確保資料表中的記錄是**唯一**的，我們設定PK就是為了達成實體完整性。  
#### 區域完整性 Domain Integrity  
確保資料在允許範圍中。  
#### 參考完整性 Referential Integrity  
確保相關聯資料表間的資料一致，避免一個資料表的記錄改變時，造成另一個資料表的內容變成無效值。  
#### 使用者定義的完整性 User-Defined Integrity  
由使用者自行定義的，例如客戶欠款超過六個月，下次他再下訂單就不賣給他。

## ER Model
#### Concepts
https://www.tutorialspoint.com/dbms/er_model_basic_concepts.htm

#### ER Diagram Representation
https://www.tutorialspoint.com/dbms/er_diagram_representation.htm

## Normalization
#### purpose  
  * Reduce Data Redundancy  
  * Remove Insert,Update,Delete Anomily  
  
#### Terminology  
  * Function Dependence ,FD  
   Table R ,AttributeX,Y,Z ,so R={X,Y,Z}  
   X→Y, where X functionally determines Y. The left-hand side attributes determine the values of attributes on the right-hand side.  
   
   * Full Functional Dependency  
    (X,Y)→Z，若移除任一X，Y屬性時 (X,Y)→Z**不**存在，此時稱Z完全功能相依於(X,Z)  
     ex. (學號,課號)→ 成績 
   
   * Partial Functional Dependency  
     (X,Y)→Z，若移除任一X，Y屬性時 (X,Y)→Z**仍**存在，此時稱Z部分功能相依於(X,Z)  
     ex. (學號,身分證字號)→姓名  
   
   * Transitive Dependency  
   X→Y,Y→Z 則 X→Z 則稱Z遞移相依於X  
    ex.課程代號決定老師編號，老師編號決定老師姓名  
    
#### Normalization正規化
  * First Normal Form,1NF  
  符合1NF，且資料表中的所有紀錄之屬性內含都是基元值(Atomic Value)  
  
  * Second Normal Form,2NF  
  每一非鍵屬性必須完全相依於主鍵。  
  ex.學號決定姓名、性別  
  
  *  Third Normal Form  
  符合2NF，且各欄位與主見沒有遞移相依的關係
  
  * BCNF  
  符合3NF，若主鍵為單一欄位組成則符合BCNF，若為複合主鍵和主鍵中的欄位不可相依於其它欄位  
     
## Transaction
#### ACID Properties

* 單元性 Atomicity  
整個交易的敘述視為一個執行單元，要就全部成功，不然就全部取消。

* 一致性 Consistency  
在交易完成後，資料庫的內容必須更新妥當(包括各個資料表、索引等均處於一致的狀態)

* 隔離性 Isolation  
在交易中所使用的資料，必須與其他同時在進行的交易做適度隔離。

* 永久性 Durability   
交易一旦確認後，其所作的資料修改將視為永久性的，無法再用ROLLBACK回復。

#### 交易隔離等級 Isolation Level

#### 資料鎖定 Lock

## NoSQL
* Key-Value Database  
  - 特性：採用Key-Value資料架構建立分散式的資料庫，具有水平擴充性。  
  - 用途：可用來儲存設群網路或設社交戲產生的TB或PB等級資料。  
  - 常見產品：Google BigTable、Hadoop HBase  
 
* In-memory Database  
  * 特性：利用記憶體建立分散式資料庫，來加快讀取資料的速度
  * 用途：適合用來作為網站快取，加速玩家取得遊戲資訊的速度
  * 常見產品：Redis  

* Document Database  
  - 特性：可儲存結構鬆散或非結構性的資料。  
  - 用途：適合用來儲存網頁資料或各種XML格式的資料，也可存圖片或影音資料。  
  - 常見產品：MongoDB

* Graph Database  
  - 特性：運用圖學架構來儲存節點間關係資料架構，基本的資料結構包括節點、關係和屬性。
  - 用途：可用樹狀結構來記錄社交網站的朋友關係，或用來儲存地圖上每一點和鄰近點的關係，可計算點語點之間最短距離或計算出人與人之間最短交友距離。
  - 常見產品：Neo4j
 
* reference：https://www.ithome.com.tw/news/92506
* reference：https://www.ithome.com.tw/news/92507

