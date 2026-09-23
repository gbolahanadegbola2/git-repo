use('gadgetStore');

db.createCollection('products', {
    validator: {
        $jsonSchema: {
            bsonType: 'object',
            required: ['name', 'price', 'inStock'],
            properties: {
                name: {
                    bsonType: 'string',
                    description: 'must be a string'
                },
                price: {
                    bsonType: ['int', 'double'],
                    description: 'must be an integer or double'
                },
                inStock: {
                    bsonType: 'bool',
                    description: 'must be a boolean'
                },
                specs: {
                    bsonType: 'object',
                    properties: {
                        brand: {
                            bsonType: 'string',
                            description: 'must be a string'
                        }
                    }
                }
            }
        }
    },
    validationAction: 'error'
});

// ===== STEP 2 =====

use('gadgetStore');

db.products.insertMany([
    {
        name: 'Wireless Mouse',
        price: 35,
        inStock: true,
        specs: {
            brand: 'Logitech'
        }
    },
    {
        name: 'Mechanical Keyboard',
        price: 89.99,
        inStock: true,
        specs: {
            brand: 'Keychron'
        }
    },
    {
        name: 'Gaming Monitor',
        price: 249.99,
        inStock: false,
        specs: {
            brand: 'Samsung'
        }
    }
]);

// ===== STEP 3 =====

use('gadgetStore');

db.products.insertOne({
    name: 'Broken Product',
    inStock: true,
    specs: {
        brand: 'TestBrand'
    }
});

// ===== STEP 4 =====

use('gadgetStore');

db.products.updateOne(
    { name: 'Wireless Mouse' },
    { $set: { category: 'Accessories' } }
);
use('gadgetStore');

db.products.findOne({ name: 'Wireless Mouse' });

// ===== STEP 5 =====

use('gadgetStore');

db.products.updateOne(
    { name: 'Wireless Mouse' },
    { $inc: { price: 15 } }
);

// ===== STEP 6A =====

use('gadgetStore');

db.products.updateOne(
    { name: 'Wireless Mouse' },
    { $push: { tags: 'wireless' } }
);

// ===== STEP 6B =====

use('gadgetStore');

db.products.updateOne(
    { name: 'Wireless Mouse' },
    { $push: { tags: 'bestseller' } }
);

// ===== STEP 6C =====

use('gadgetStore');

db.products.updateOne(
    { name: 'Wireless Mouse' },
    { $pull: { tags: 'wireless' } }
);

// ===== STEP 7A =====

// ===== STEP 7A =====

use('gadgetStore');

db.products.find({
    price: { $gte: 50 }
});

// ===== STEP 7B =====

use('gadgetStore');

db.products.find({
    'specs.brand': 'Logitech'
});

// ===== CLEANUP =====

use('gadgetStore');

db.products.deleteMany({
    name: 'Wireless Mouse',
    price: 35
});

// ===== STEP 7C =====

use('gadgetStore');

db.products.find({
    category: { $in: ['Accessories', 'Gaming'] }
});

// ===== STEP 8A =====

use('gadgetStore');

db.createCollection('orders');

// ===== STEP 8B =====

use('gadgetStore');

db.orders.insertOne({
    productId: ObjectId('6ab2f4046a7f31b3c6f7e51c'),
    quantity: 2
});

// ===== STEP 8C =====

use('gadgetStore');

db.orders.aggregate([
    {
        $lookup: {
            from: 'products',
            localField: 'productId',
            foreignField: '_id',
            as: 'product'
        }
    }
]);

// ===== STEP 8D =====

use('gadgetStore');

db.orders.aggregate([
    {
        $lookup: {
            from: 'products',
            localField: 'productId',
            foreignField: '_id',
            as: 'product'
        }
    },
    {
        $unwind: '$product'
    }
]);

// ===== STEP 8E =====

use('gadgetStore');

db.orders.aggregate([
    {
        $lookup: {
            from: 'products',
            localField: 'productId',
            foreignField: '_id',
            as: 'product'
        }
    },
    {
        $unwind: '$product'
    },
    {
        $project: {
            _id: 0,
            productName: '$product.name',
            quantity: 1
        }
    }
]);