### Usage

java -jar SpanQueryCLI.jar /<fieldName/> /<query/>

#### Example Queries

Sample Queries

(can could) /12 "figur*" - Can or Could within 12 of firgure*

(search*) /75 (could* /10 "lat* night")

"can* expect*"

"(can might) expect*" - can expect* or might expect*

"(red green blue)(cluster* node* shard*)"
