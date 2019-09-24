//
//  XCPlanetTestCase.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCPlanetTestCase: XCTestCase {

    var sut: Planet!
    
    override func setUp() {
        sut = Planet(id: "foo", name: "bar")
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testInitialization() {
        XCTAssertNotNil(sut)
        XCTAssertEqual(sut.id, "foo")
        XCTAssertEqual(sut.name, "bar")
        XCTAssertEqual(sut.people, [])
    }
    
    func testPlanetCantSetWrongCitizenAsPresedent() {
        let person = Person(id: "foo", name: "bar")
        
        person.position = .engenere
        sut.presedent = person
        
        XCTAssertNil(sut.presedent)
        
        person.position = .economist
        sut.presedent = person
        
        XCTAssertNil(sut.presedent)
        
        person.position = .unowned
        sut.presedent = person
        
        XCTAssertNil(sut.presedent)
    }

    func testPlanetContainsCurrectCitizenAsPresedent() {
        let person = Person(id: "foo", name: "bar")
        person.position = .presedent
        
        sut.presedent = person
        
        XCTAssertNotNil(sut.presedent)
        XCTAssertTrue(sut.presedent?.position == .presedent)
    }
    
    func testBornNewPerson() {
        let oldPeopleCount = sut.people.count
        
        sut.bornPerson()
        let newPeopleCount = sut.people.count
        
        XCTAssertGreaterThan(newPeopleCount, oldPeopleCount)
    }
}
