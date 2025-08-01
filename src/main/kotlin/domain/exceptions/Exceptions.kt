package org.example.domain.exceptions


open class SystemExceptions(message: String) : Exception(message)
class InvalidToAddException(message: String): SystemExceptions(message)
class InvalidToDeleteException(message: String): SystemExceptions(message)
class NotFoundException(message: String): SystemExceptions(message)
class SmallerThanZeroException(message: String): SystemExceptions(message)
class WithDrawException(message: String): SystemExceptions(message)
class InvalidIdException(message: String): SystemExceptions(message)
class InvalidAmountException(message: String): SystemExceptions(message)