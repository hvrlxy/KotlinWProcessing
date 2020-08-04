allocate-registers one two n oddCount loop end test ai tmp i evenCount

    li one 1
    li two 2

    li loop loopL
    li end endL

    read n
    li oddCount 0
    li i 0

loopL:
    slt test i n
    jeqz test end
    read ai
    rem tmp ai two
    add oddCount oddCount tmp
    add i i one
    j loop

endL:
    sub evenCount n oddCount
    write evenCount
    halt