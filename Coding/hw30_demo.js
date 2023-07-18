use testDB;

// Task 2: Create oms_company_address collection
db.createCollection('oms_company_address');

// Task 3: Insert few random entries to oms_company_address collection
db.oms_company_address.insertMany([
  { companyName: 'Company 1', address: 'Address 1' },
  { companyName: 'Company 2', address: 'Address 2' },
  { companyName: 'Company 3', address: 'Address 3' },
]);

// Task 4: Read one entry from oms_company_address collection
db.oms_company_address.findOne({ companyName: 'Company 1' });

// Task 5: Read all entries from oms_company_address collection
db.oms_company_address.find();

// Task 6: Update one entry in oms_company_address collection
db.oms_company_address.updateOne(
  { companyName: 'Company 1' },
  { $set: { address: 'New Address' } }
);

// Task 7: Remove one entry from oms_company_address collection
db.oms_company_address.deleteOne({ companyName: 'Company 2' });
