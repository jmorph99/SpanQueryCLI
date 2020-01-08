### Usage

java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar fieldName query

#### sample

java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' 'love /5 hate'

#### Example Queries
in\
java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' '(can could) /12 "figur*"'\
out\
{ "query":{\
  "span_near": { "clauses": [{\
    "span_or": { "clauses": [{\
      "span_term" : {"content":"can"}      },{\
      "span_term" : {"content":"could"}      }\
    ]}},{\
    "span_multi": { "match": { "prefix" : {"content" :{ "value":"figur", "rewrite": "constant_score_boolean"}}}}    }\
  ] , "slop": 12,"in_order":false}}}\
\
in
java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' '(search*) /75 (could* /10 "lat* night")'
out
{ "query":{
  "span_near": { "clauses": [{
    "span_multi": { "match": { "prefix" : {"content" :{ "value":"search", "rewrite": "constant_score_boolean"}}}}    },{
    "span_near": { "clauses": [{
      "span_multi": { "match": { "prefix" : {"content" :{ "value":"could", "rewrite": "constant_score_boolean"}}}}      },{
      "span_near": { "clauses": [{
        "span_multi": { "match": { "prefix" : {"content" :{ "value":"lat", "rewrite": "constant_score_boolean"}}}}        },{
        "span_term" : {"content":"night"}        }
      ] , "slop": 0,"in_order":true}}
    ] , "slop": 10,"in_order":false}}
  ] , "slop": 75,"in_order":false}}}

in
java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' '"can* expect*"'
out
{ "query":{
  "span_near": { "clauses": [{
    "span_multi": { "match": { "prefix" : {"content" :{ "value":"can", "rewrite": "constant_score_boolean"}}}}    },{
    "span_multi": { "match": { "prefix" : {"content" :{ "value":"expect", "rewrite": "constant_score_boolean"}}}}    }
  ] , "slop": 0,"in_order":true}}}

in
java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' '"(can might) expect*"'10
out
{ "query":{
  "span_near": { "clauses": [{
    "span_or": { "clauses": [{
      "span_term" : {"content":"can"}      },{
      "span_term" : {"content":"might"}      }
    ]}},{
    "span_multi": { "match": { "prefix" : {"content" :{ "value":"expect", "rewrite": "constant_score_boolean"}}}}    }
  ] , "slop": 0,"in_order":true}}}

in
java -jar classes/artifacts/SpanSearchCLI_jar/SpanSearchCLI.jar 'content' '"(red green blue)(cluster* node* shard*)"'
out
{ "query":{
  "span_near": { "clauses": [{
    "span_or": { "clauses": [{
      "span_term" : {"content":"red"}      },{
      "span_term" : {"content":"green"}      },{
      "span_term" : {"content":"blue"}      }
    ]}},{
    "span_or": { "clauses": [{
      "span_multi": { "match": { "prefix" : {"content" :{ "value":"cluster", "rewrite": "constant_score_boolean"}}}}      },{
      "span_multi": { "match": { "prefix" : {"content" :{ "value":"node", "rewrite": "constant_score_boolean"}}}}      },{
      "span_multi": { "match": { "prefix" : {"content" :{ "value":"shard", "rewrite": "constant_score_boolean"}}}}      }
    ]}}
  ] , "slop": 0,"in_order":true}}}

