### Usage

java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar fieldName query

#### sample

java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' 'love /5 hate'

#### Example Queries

(can could) /12 "figur*" - Can or Could within 12 of firgure*

(search*) /75 (could* /10 "lat* night")

"can* expect*"

"(can might) expect*" - can expect* or might expect*

"(red green blue)(cluster* node* shard*)"
