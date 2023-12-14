{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Eta reduce" #-}
{-# HLINT ignore "Redundant bracket" #-}

data Pilha a = Pilha { valores :: [a], topo :: Int } deriving Show

--"Construtor"
criarPilha :: Pilha a
criarPilha = Pilha { valores = [], topo = -1 }

-- (topo pilha) acessa campo topo em Pilha
pilhaVazia :: Pilha a -> Bool
pilhaVazia pilha = (topo pilha) == -1


push :: a -> Pilha a -> Pilha a
push x pilha = Pilha { valores = x : valores pilha, topo = topo pilha + 1 }


--foldr: push é aplicado para todos elementos começando de "pilha"
pushVarios :: [a] -> Pilha a -> Pilha a
pushVarios elements pilha = foldr push pilha elements


pushPilha :: Pilha a -> Pilha a -> Pilha a
pushPilha pilha1 pilha2 = pushVarios (valores pilha1) pilha2

-- init retorna todos menos o ultimo elemento
pop :: Pilha a -> Pilha a
pop pilha =
    if (pilhaVazia pilha) then pilha
    else (Pilha { valores = init (valores pilha), topo = ((topo pilha) - 1) })


popQuant :: Int -> Pilha a -> Pilha a
popQuant num pilha =
    if (num <= 0) then pilha
    else popQuant (num - 1) (pop pilha)

-- Maybe - presença opcional de um valor (Nothing "null" | Just)
topoPilha :: Pilha a -> Maybe a
topoPilha pilha =
    if (pilhaVazia pilha) then Nothing
    else Just (last (valores pilha))


main :: IO ()
main = do

    --Push para uma lista vazia (criarPilha)
    let pilha1 = pushVarios ["A", "B", "C"] criarPilha
        pilha2 = pop pilha1
        topoFinal = topoPilha pilha2
    print pilha2
