use test
db.oms_company_address.insertMany([
    {
        id: NumberLong(2),
        address_name: "Address 2",
        send_status: 0,
        receive_status: 1,
        name: "Jane",
        phone: "987-654-3210",
        province: "DEF",
        city: "MNO",
        region: "STU",
        detail_address: "456 Elm Street"
    },
    {
        id: NumberLong(3),
        address_name: "Address 3",
        send_status: 1,
        receive_status: 0,
        name: "Mike",
        phone: "555-123-4567",
        province: "GHI",
        city: "PQR",
        region: "XYZ",
        detail_address: "789 Oak Avenue"
    },
    {
        id: NumberLong(4),
        address_name: "Address 4",
        send_status: 1,
        receive_status: 1,
        name: "Emily",
        phone: "111-222-3333",
        province: "JKL",
        city: "UVW",
        region: "XYZ",
        detail_address: "321 Maple Street"
    }
])

db.oms_company_address.find({ id: 2 })

db.oms_company_address.find()

db.oms_company_address.updateOne(
   { id: 2 }, // 查询条件，匹配 id 为 2 的记录
   {
     $set: {
       address_name: "New York"
     }
   } // 更新的字段和值
)

db.oms_company_address.deleteOne({ id: 2 })