<template>
    <div class="wordInfo" >
        <h1 class="wordName"> {{ this.word.name }}  </h1>
        <h3 class="wordType"> <i style="opacity: 70%;">Вид на збор:</i>  {{ this.word.type }} </h3>
        <ol type="1" class="definitions">
            <li v-for="def in this.definitions" v-bind:key="def.id">
                <h3>{{ def.definition_name }}</h3>
                <h4>
                    <i style="opacity: 70%;">Пример: </i>
                    <span v-show="def.definition_example != 'No example'">{{ def.definition_example }}</span>
                    <span v-show="def.definition_example == 'No example'">Нема пример</span>
                </h4>
            </li>
            
        </ol>
        
    </div>

</template>
<script>
    export default{
        name: "WordComponent",
        props: {
            wordId: Number,
            letter: Object,
            word: Object,
            definitions: Array

        }
    }
</script>

<style scoped>
.wordInfo{
    width: 70%;
    height: 650px;
    margin-top: 30px;
    background-color: whitesmoke;
    padding: 40px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;

}

.wordName{
    color: black;
}

.definitions{
    text-align: left;
    margin-top: 30px;
}

</style>