# CICD-1 Coding Test — Review, Improve and Reflect

**Student ID: G00467054 **  
**Examination group:** A (Room Booking)  
**Original examination pull-request URL (`exam-work`): https://github.com/LowRands/G00467054Week7TestCICD/pull/1 **  
**New review repository URL:**

## 1. My original examination self-assessment

Review the code **as submitted in the original examination**. Do not change the original repository, branch or pull request. Check your own Group A or Group B examination paper and award marks only for evidence present in the original submission.

### Task 1 — /40
**My mark: 20**  
**Evidence from the original code (files, methods, working or missing requirements):**
- My bookingcontroller has code that allows a user to create a booking, to fetch bookings and the capacity of rooms
- The CreateBookingRequest file allows for the user to enter name, amount of students and the room id
- The booking service has code to check that the room id and the name is entered and not left blank
- The roomService links to the roomRepository, which creates a list of the room ID's

### Task 2 — /40
**My mark: 20**  
**Evidence from the original code:**
- The bookingService checked if the room id and name was entered as a value and not left blank
- The bookingController has PostMappings and GetMappings that allows the user to create a booking and view their booking
- The RoomController has a getMapping that allows the user to view the rooms available

### Task 3 — /20
**My mark: 0**  
**Evidence from the original code:**
- Wasn't able to run it on swagger, let alone search by room IDs, the amount of people in the bookings

**Total self-assessed original examination mark: 40/100**

**Checkpoint:** Commit this completed self-assessment as the **first review commit in your new repository**, before you modify or add application code. The lecturer decides the official original examination mark.

## 2. Corrections and improvements in my new project

Start from a **fresh copy of the starter template for your own exam group**, in a **new GitHub repository**. You may consult or selectively reuse your own original examination code, but the new project must demonstrate that you understand and can correct it. Do not change your original examination submission.

Describe **two or three important problems** in your original code. For each, explain what was wrong, which class or method you changed in the new project, and why the corrected approach works.

**Problem and correction 1:**

**Problem and correction 2:**

**Problem and correction 3 (optional):**

## 3. API testing and evidence

Use Swagger UI or another HTTP client. For **at least four meaningful checks**, record the request/input, expected result, actual HTTP status/response, and pass/fail. Include unsuccessful cases; a running application alone is not enough.

**Test 1 — successful booking request:**
- Request / input:
- name "Ethan"
- roomID "1"
- attendees "2"

- Expected: status = "Active", RoomName = "Lab 201"
- Actual HTTP status / body: 201/Created. Status = "Active", RoomName = "Lab 201"
- Pass / fail: Pass

**Test 2 — invalid input or excessive attendee count:**
- Request / input:
- name "Ethan"
- roomID "1"
- attendees "25"

- Expected: Error 
- Actual HTTP status / body: 409 Error
- Pass / fail: Pass

**Test 3 — missing booking or room:**
- Request / input: BookingID = "2"
- Expected: Error, as BookingID = "2", doesn't exist
- Actual HTTP status / body: 404 Error, not found
- Pass / fail: Pass

**Test 4 — requirement specific to my group:**
- Request / input: (Bookings/search) roomName = "Lab 201"
- Expected: 
- attendees = "23"
- status: "ACTIVE"
- (next booking)
- attendees = "2"
- status = "Active"
- Actual HTTP status / body: 200, Found 
- Pass / fail: Pass

**Group A:** Demonstrate `GET /api/bookings/search?roomName=...` using an exact room name, bookings ordered by attendee count descending, and an empty list for no matches. Add checks if necessary to show all three behaviours.

## 4. Reflection

**I understood the assignment and what I had to do, I struggled with time and because I coded something wrong in my bookingcontroller
and it broke and wouldn't appear on swagger. I couldn't find my error until after the exam**

**Which Spring Boot, JPA, validation, JPQL or OpenFeign concept became clearer after correcting my code? Give a specific example.**
- " @ManyToOne(optional = false, fetch = FetchType.LAZY)" 
- allows many bookings for each room
- "optional = false" the field can't be null
- "FetchType.Lazy" only loads from database when requested, avoids extra queries

**What will I do differently in my next coding test or API development task?**
- I would run my code more often and if I get an error and swagger doesn't work, I only have to back track a few lines of code
- I would read the requirements on the test sheet and break it down into a checklist and go through each task
- I would revise core patterns before the exam such as @Entity with @ManyToOne, DTOs with @NotBlank, @Size, @Positive
## Review lab assessment — 20 marks

- Honest original self-assessment with code evidence: **4 marks**
- Explanation of mistakes and Spring Boot concepts: **6 marks**
- Corrections in the new application: **4 marks**
- API testing and demonstration of understanding: **4 marks**
- Reflection and future improvement: **2 marks**

**Total: 20 marks.** Simply submitting a working solution does not demonstrate the learning required by this review.

## Proposed mark recovery — only if confirmed for CICD-1

If the same approach as OOP is adopted, the review could recover **up to 30% of marks lost** in the original examination, scaled by the review-lab mark.

**Marks recovered = (100 − official original exam mark) × 0.30 × (review lab mark ÷ 20)**

Example: exam **40/100** and review **16/20** → **14.4 recovered marks**, revised exam **54.4/100**. This is **not an approved CICD-1 policy unless confirmed by the lecturer**. The original official exam mark—not your self-awarded grade—is used in the calculation.

## Submission

Commit and push the **new review repository** with the completed README, corrected Spring Boot code and API-test evidence. Submit its GitHub URL on Moodle. **Do not push any changes to the original examination repository or `exam-work` pull request.**