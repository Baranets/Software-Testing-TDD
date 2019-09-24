//
//  XCSpaceShipTestCase.swift
//  Test1Tests
//
//  Created by Maxim Baranets on 24/09/2019.
//  Copyright © 2019 AppToBe. All rights reserved.
//

import XCTest
@testable import Test1

class XCSpaceShipTestCase: XCTestCase {

    var sut: Spaceship!
    
    override func setUp() {
        sut = Spaceship(id: "foo", name: "bar")
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testMovingSpacshipToNewLocation() {
        let location = Location(x: Double.random(in: 0...100),
                                y: Double.random(in: 0...100),
                                z: Double.random(in: 0...100))
        
        XCTAssertNoThrow(try? sut.warp(to: location))
        
        XCTAssertEqual(sut.location, location)
    }
    
    func testWarpUnableOnSameLocation() {
        do {
            XCTAssertThrowsError(try sut.warp(to: sut.location))
        }
    }
    
    func testEquatableLocationsWhenEquel() {
        let location1 = Location(x: 0, y: 0, z: 0)
        let location2 = Location(x: 0, y: 0, z: 0)
        
        XCTAssertEqual(location1, location2)
    }
    
    func testEquetableLocationsWhenDifferent() {
        let location1 = Location(x: 3, y: 2, z: 1)
        let location2 = Location(x: 4, y: 5, z: 6)
        
        XCTAssertNotEqual(location1, location2)
    }
    
    func testRecruitingNewEngenere() {
        let person = Person(id: NSUUID().uuidString,
                            name: NSUUID().uuidString)
        person.position = .engenere
        let oldPeopleCount = sut.personal.count
        
        do {
           XCTAssertNoThrow(try sut.recruit(person))
        }
        
        XCTAssertTrue(sut.personal.contains(person))
        XCTAssertEqual(oldPeopleCount + 1, sut.personal.count)
    }
    
    func testRecruitingNewEconomistThrows() {
        let person = Person(id: NSUUID().uuidString,
                            name: NSUUID().uuidString)
        person.position = .economist
        let oldPeopleCount = sut.personal.count
        
        do {
            XCTAssertThrowsError(try sut.recruit(person))
        }
        
        XCTAssertFalse(sut.personal.contains(person))
        XCTAssertEqual(oldPeopleCount, sut.personal.count)
    }

}
