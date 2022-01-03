@SmokeTest @Address
Feature: Address controls

  Background: Login user
    Given I select city "TR_ISTANBUL"

  @Address
  Scenario Outline: Unpinned user address should be listed in available addresses
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    Then I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I add address with defined parameters
    When My addresses list should be available
    Then I check selected address exists in available addresses response
    * I validate selected address IsAvailable "false" in available address response
    * I validate selected address AddressLine1 "<AddressLine1>" in available address response
    * I validate selected address AddressType <AddressType> in available address response
    * I validate selected address City "<City>" in available address response
    * I validate selected address Description "<Description>" in available address response
    * I validate selected address Email "<Email>" in available address response
    * I validate selected address FirstName "<FirstName>" in available address response
    * I validate selected address AreaId "<AreaId>" in available address response
    * I validate selected address TelephoneNumber "<TelephoneNumber>" in available address response
    * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|
      |   Göztepe  |  Kampus   |     2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5553332211   |

  @Address
  Scenario Outline: Pinned user address should be listed in available addresses
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    Then I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    When My addresses list should be available
    Then I check selected address exists in available addresses response
    * I validate selected address IsAvailable "true" in available address response
    * I validate selected address AddressLine1 "<AddressLine1>" in available address response
    * I validate selected address AddressType <AddressType> in available address response
    * I validate selected address City "<City>" in available address response
    * I validate selected address Description "<Description>" in available address response
    * I validate selected address Email "<Email>" in available address response
    * I validate selected address FirstName "<FirstName>" in available address response
    * I validate selected address AreaId "<AreaId>" in available address response
    * I validate selected address TelephoneNumber "<TelephoneNumber>" in available address response
    * I validate selected address Latitude <Latitude> in available address response
    * I validate selected address Longitude <Longitude> in available address response
    * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName| AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |  Kampus   |      2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5335554433   |40.98196411|29.06356239|

  @Address
  Scenario Outline: User can proceed with Mahalle after pinning address
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I add address with defined parameters
    When I get selected address action with AreaId "<AreaId>"
    Then I validate address ActionType is 1 in address action response
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I edit selected address
    When I navigate to added address details
    * I validate selected address Latitude <Latitude> in address detail response
    * I validate selected address Longitude <Longitude> in address detail response
    * I delete added user address
    When I get selected address action with AreaId "<AreaId>"
    Then I validate address ActionType is 0 in address action response

    Examples: Expected Address Details
      |AddressLine1|AddressName| AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |  Kampus   |      2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5553332211   |40.98196411|29.06356239|

  @Address
  Scenario Outline: User can list pinned addres details
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    Then I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    When I navigate to added address details
    * I validate selected address AddressLine1 "<AddressLine1>" in address detail response
    * I validate selected address AddressType <AddressType> in address detail response
    * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName| AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |  Kampus   |      2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5553332211   |40.98196411|29.06356239|

  @Address
  Scenario Outline: User can list unpinned addres details
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I add address with defined parameters
    When I navigate to added address details
    * I validate selected address IsAvailable "false" in address detail response
    * I validate selected address AddressLine1 "<AddressLine1>" in address detail response
    * I validate selected address AddressType <AddressType> in address detail response
    * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|
      |   Göztepe  |  Kampus   |     2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5553332211   |

  @Address
  Scenario Outline: User Can not proceed with unpinned address in Mahalle - Action Type 1
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I add address with defined parameters
    When I get selected address action with AreaId "<AreaId>"
    Then I validate address ActionType is 1 in address action response
    * I validate selected AddressId in address action response
    * I validate selected AddressType <AddressType> in address action response
    * I validate selected City "<City>" in address action response
    * I validate selected Latitude is null in address action response
    * I validate selected Longitude is null in address action response
    * I delete added user address
    When I get selected address action with AreaId "<AreaId>"
    * I validate address ActionType is 0 in address action response

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|
      |   Göztepe  |  Kampus   |     2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5553332211   |

  @Address
  Scenario Outline: User Can proceed with pinned address in Mahalle - Action Type 2
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    When I get selected address action with AreaId "<AreaId>"
    Then I validate address ActionType is 2 in address action response
    * I validate selected AddressId in address action response
    * I validate selected AddressType <AddressType> in address action response
    * I validate selected City "<City>" in address action response
    * I validate selected Latitude is <Latitude> in address action response
    * I validate selected Longitude is <Longitude> in address action response
    * I delete added user address
    When I get selected address action with AreaId "<AreaId>"
    * I validate address ActionType is 0 in address action response

    Examples: Expected Address Details
      |AddressLine1|AddressName| AddressType|    City   |   Description   |          Email         |FirstName|LastName |               AreaId               |                   AreaName              |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |  Kampus   |      2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5553332211   |40.98196411|29.06356239|

  @Address
  Scenario Outline: Edit address validations
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    * I set selected address "City" ""
    * I set selected address "AddressLine1" ""
    * I set selected address "Description" ""
    * I set selected address "FirstName" ""
    * I set selected address "LastName" ""
    * I set selected address "AreaId" ""
    * I set selected address "TelephoneNumber" ""
    * I edit selected address
    * I check edited address status is 400


    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|   City    |   Description   |            Email       |FirstName|LastName |                 AreaId             |        AreaName      |TelephoneNumber|MobileTelephoneNumber|  Latitude | Longitude |IsFromAutoComplete|Organization|
      |   Göztepe  |    Home   |      0    |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   |     5335554433      |40.98196411|29.06356239|        true      |            |

  @Address
  Scenario Outline: Add address validations
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    * I check added address "<ErrorMessage>" error message and status is 400

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|City   |   Description   |  Email |  ErrorMessage  |FirstName|LastName |   AreaId   |   AreaName   |TelephoneNumber|MobileTelephoneNumber|  Latitude | Longitude |IsFromAutoComplete|Organization|
      |   Göztepe  |   Home| 0 |   | TestAddressHome |test_NoAddress@gmail.com|   'City' boş olmamalı.  |  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      ||   Home| 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com| 'Address Line1' boş olmamalı.  |  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   | 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|  'Address Name' boş olmamalı.  |  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|'Telephone Number' boş olmamalı.|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| |test_NoAddress@gmail.com|  'Description' boş olmamalı.   |  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|  'First Name' boş olmamalı.| |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|   'Last Name' boş olmamalı.|  Test   | |6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|'Area Id' boş olmamalı. |  Test   |noAddress||Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| TestAddressHome || 'Email' boş olmamalı.  |  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   | 5335554433  |40.98196411|29.06356239|   true   ||
      |   Göztepe  |   Home| 0 |TR_ISTANBUL| TestAddressHome |test_NoAddress@gmail.com|Telefon numarası formatı hatalı.|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|   55533322| 5335554433  |40.98196411|29.06356239|   true   ||

  @Address
  Scenario Outline: Corporate address validations
    Given I am an authorized user with "tugcekor" "Mahalle1!"
    * My addresses list should be available
    * I select pinned address with id "<AddressId>"
    * I get selected address action with AreaId "<AreaId>"
    Then I validate address ActionType is 2 in address action response
    * I validate selected address ReadOnly "true" in address action response
    * I validate selected AddressType <AddressType> in address action response
    * I validate selected City "<City>" in address action response
    * I validate selected Latitude is <Latitude> in address action response
    * I validate selected Longitude is <Longitude> in address action response
    When I navigate to added address details
    * I delete added user address
    * I check address delete response status is 400 and error message is "Kurumsal cüzdan adresi silinemez."

    Examples: Expected Corporate Address Details
      |                  AddressId           |                                                     AddressLine1                                         |       AddressName         |AddressType|    City   |   Description   |          Email          |FirstName|LastName|               AreaId               |             AreaName           | Latitude| Longitude|ReadOnly|
      |{4fca1785-2176-4d0a-a114-3259076ff3bc}|Esentepe Mahallesi, Büyükdere Caddesi, Dede Korkut Sok. No:28/01 34394, Şişli, İstanbul - Yemeksepeti Park|Kurumsal Cüzdan Ofis Adresi|     1     |TR_ISTANBUL| Yemeksepeti Park|tugce.kor@yemeksepeti.com|  Tuğçe  |  Kor   |d921aa83-6fbf-442c-aeec-469994794c9c|Şişli (Esentepe Mah. - Plazalar)|41.076781|29.0110943|  true  |

  @Address
  Scenario Outline: User add pinned address in different types
    Given I am an authorized user with "testuserNoAddress@yemeksepeti.com" "Mahalle1!"
    * My addresses list should be available
    * I check my address list size is 0
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    When I get selected address action with AreaId "<AreaId>"
    Then I validate address ActionType is 2 in address action response
    * I validate selected AddressType <AddressType> in address action response
    When My addresses list should be available
    Then I validate selected address AddressType <AddressType> in available address response
    When I navigate to added address details
    * I validate selected address AddressType <AddressType> in address detail response
    * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|    City   |   Description   |          Email         |FirstName|LastName |              AreaId                |                   AreaName              |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |   Work    |     1     |TR_ISTANBUL| TestAddressWork |test_NoAddress@gmail.com|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|          Kadıköy (Göztepe Mah.)         |  5335554433   |40.98196411|29.06356239|
      |   Göztepe  |  Kampus   |     2     |TR_ISTANBUL|TestAddressCampus|test_NoAddress@gmail.com|  Test   |noAddress|6ae5584a-2126-4f79-89bc-68532f78dd0a|Bahçeşehir Üniversitesi - Göztepe Kampüsü|  5335554433   |40.98196411|29.06356239|
      |   Göztepe  |   Other   |     3     |TR_ISTANBUL| TestAddressOther|test_NoAddress@gmail.com|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|          Kadıköy (Göztepe Mah.)         |  5335554433   |40.98196411|29.06356239|

  @CheckoutAddress
  Scenario Outline: User can not list unpinned address in checkout available
    Given I am an authorized user with "mahalletestuser@yemeksepeti.com" "Mahalle1!"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I add address with defined parameters
    When My addresses list should be available
    * I select unpinned address
    Then I list available addresses in checkout
    * I validate address is not listed in available checkout response
    * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|City   |   Description   |  Email |FirstName|LastName |   AreaId   |   AreaName   |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |   Work| 1 |TR_ISTANBUL| TestAddressWork |test_NoAddress@gmail.com|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   |||

  @CheckoutAddress
  Scenario Outline: User can list pinned address in checkout available
    Given I am an authorized user with "mahalletestuser@yemeksepeti.com" "Mahalle1!"
    And  My addresses list should be available
    When  I select pinned available address
    Then I get unique basket id
    And I delete basket
    When  A list of Carşı Vendor are available on home page
    Then I select mahalle vendor from defined vendors type is "defaultFirstVendor" on home page
    When I navigate selected vendor
    * I create address info list
    * I set address info parameter is "AddressLine1" value is "<AddressLine1>"
    * I set address info parameter is "AddressName" value is "<AddressName>"
    * I set address info parameter is AddressType value is <AddressType>
    * I set address info parameter is "City" value is "<City>"
    * I set address info parameter is "Description" value is "<Description>"
    * I set address info parameter is "Email" value is "<Email>"
    * I set address info parameter is "FirstName" value is "<FirstName>"
    * I set address info parameter is "LastName" value is "<LastName>"
    * I set address info parameter is "AreaId" value is "<AreaId>"
    * I set address info parameter is "AreaName" value is "<AreaName>"
    * I set address info parameter is "TelephoneNumber" value is "<TelephoneNumber>"
    * I set address info parameter is "Latitude" value is <Latitude>
    * I set address info parameter is "Longitude" value is <Longitude>
    * I add address with defined parameters
    When My addresses list should be available
    Then I list available addresses in checkout
    * I validate address is listed in available checkout response
   * I delete added user address

    Examples: Expected Address Details
      |AddressLine1|AddressName|AddressType|City   |   Description   |  Email |FirstName|LastName |   AreaId   |   AreaName   |TelephoneNumber|  Latitude | Longitude |
      |   Göztepe  |   Work| 1 |TR_ISTANBUL| TestAddressWork |test_NoAddress@gmail.com|  Test   |noAddress|6e142710-8ca2-4d62-8c55-97a398992a15|Kadıköy (Göztepe Mah.)|  5335554433   |40.98196411|29.06356239|
