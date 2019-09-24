//
//  XCAbstractEntity.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCAbstractEntityTestCase: XCTestCase {

    class MockEntity: AbstractEntity {

        var id:   String
        var name: String
        
        init(id: String, name: String) {
            self.id   = id
            self.name = name
        }
    }
    
    var foo: MockEntity!
    
    override func setUp() {
        super.setUp()
        foo = MockEntity(id: "bar", name: "foo")
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }
    
    func testAbstractEntityInitialized() {
        XCTAssertNotNil(foo, "should be not nil")
    }

    func testAbstractEntityIsContainsNewNameWhenChange() {
        foo.name = "bar"
        XCTAssertEqual(foo.name, "bar", "strings should be equel")
    }
    
    func testAbstractEntityIsContainsNewIdWhenChange() {
        foo.id = "baz"
        XCTAssertEqual(foo.id, "baz", "strings should be equel")
    }
    
    func testGettingFullIdentifier() {
        let baz = foo.getFullIdentifier()
        XCTAssertEqual(baz, "bar foo", "strings should be equel")
    }
    
    func testObjectsIsEquels() {
        let bar = MockEntity(id:"bar", name: "foo")
        XCTAssertEqual(foo, bar, "objcts should be equels")
    }
}
