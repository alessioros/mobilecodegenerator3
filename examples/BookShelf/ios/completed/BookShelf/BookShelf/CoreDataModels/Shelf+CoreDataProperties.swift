//
//  Shelf+CoreDataProperties.swift
//  
//
//  Created by alessio rossotti on 22/08/17.
//
//

import Foundation
import CoreData


extension Shelf {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Shelf> {
        return NSFetchRequest<Shelf>(entityName: "Shelf")
    }

    @NSManaged public var name: String!
    @NSManaged public var bookCount: Int32
    @NSManaged public var has: Book?

}
