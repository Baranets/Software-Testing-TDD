//
//  XCPersonTestCase.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCPersonTestCase: XCTestCase {

    var sut: Person!
    
    override func setUp() {
        super.setUp()
        sut = Person(id: "foo", name: "bar")
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }
    

    func testInitialization() {
        let sut = Person(id: "foo", name: "bar")
        XCTAssertNotNil(sut, "Should be not nil")
    }
    
    func testSetPositionForPerson() {
        sut.position = .economist
        XCTAssertNotNil(sut.position)
        XCTAssertEqual(sut.position, Position.economist)
    }
    
    func testGetPersonTag() {
        let foo = sut.tag()
        XCTAssertEqual(foo, "foo bar ")
        
        sut.position = .engenere
        let bar = sut.tag()
        XCTAssertEqual(bar, "foo bar Engenere")
    }

}
