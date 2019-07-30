Transaction
===
ACID Properties
---
* 單元性 Atomicity  
整個交易的敘述視為一個執行單元，要就全部成功，不然就全部取消。

* 一致性 Consistency  
在交易完成後，資料庫的內容必須更新妥當(包括各個資料表、索引等均處於一致的狀態)

* 隔離性 Isolation  
在交易中所使用的資料，必須與其他同時在進行的交易做適度隔離。

* 永久性 Durability   
交易一旦確認後，其所作的資料修改將視為永久性的，無法再用ROLLBACK回復。

交易隔離等級 Isolation level
---

資料鎖定 Lock
---
