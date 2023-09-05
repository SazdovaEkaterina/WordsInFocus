<template>
    <div class="wordInfo" >
        <h1 class="wordName"> {{ this.word.name }}  </h1>
        <h3 class="wordType"> <i style="opacity: 70%;">Вид на збор:</i>  {{ this.word.type }} </h3>
        
    </div>

</template>
<script>
    export default{
        name: "WordComponent",
        props: {
            wordId: String,
            letter: Object,
            word: Object

        },
        data() {
            return {
                
            }
        },
        methods: {
            
        },
        beforeMount(){
             
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

</style>